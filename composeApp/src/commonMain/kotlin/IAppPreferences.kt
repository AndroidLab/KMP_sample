import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

/**
 * Определяет предпочтения приложения.
 */
interface IAppPreferences {
    /**
     *
     */
    suspend fun isDarkModeEnabled(): Boolean

    /**
     *
     */
    suspend fun changeDarkMode(isEnabled: Boolean): Preferences

    companion object {
        operator fun invoke(): IAppPreferences = AppPreferences()
    }
}

/**
 *
 */
internal class AppPreferences(
    private val dataStore: DataStore<Preferences> = createDataStorePreferences(
        corruptionHandler = null,
        coroutineScope = CoroutineScope(SupervisorJob().plus(Dispatchers.IO)),
        migrations = emptyList()
    )
) : IAppPreferences {

    private companion object {
        private const val PREFS_TAG_KEY = "AppPreferences"
        private const val IS_DARK_MODE_ENABLED = "prefsBoolean"
    }

    private val darkModeKey = booleanPreferencesKey("$PREFS_TAG_KEY$IS_DARK_MODE_ENABLED")

    override suspend fun isDarkModeEnabled() = dataStore.data.map { preferences ->
        preferences[darkModeKey] ?: false
    }.first()

    override suspend fun changeDarkMode(isEnabled : Boolean) = dataStore.edit { preferences ->
        preferences[darkModeKey] = isEnabled
    }
}