package org.example.project.preferences

import androidx.datastore.core.DataMigration
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import okio.Path.Companion.toPath


/**
 * Представляет предпочтения приложения.
 * @param dataStore Хранилище данных.
 */
class AppPreferences(
    private val dataStore: DataStore<Preferences>
) {
    companion object {
        /**
         * Возвращает название файла предпочтений.
         * .preferences_pb - стандард для десктопа, нельзя менять, не упадет, но работать не будет.
         */
        const val APP_PREFERENCES = "app.preferences_pb"

        private const val PREFS_TAG_KEY = "AppPreferences"
        private const val IS_DARK_MODE_ENABLED = "prefsBoolean"

        /**
         * Создает предпочтения с настройками по умолчанию.
         */
        fun getAppDataStoreWithDefaults(
            corruptionHandler: ReplaceFileCorruptionHandler<Preferences>? = null,
            coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            migrations: List<DataMigration<Preferences>> = emptyList(),
            path: () -> String,
        ): DataStore<Preferences> = PreferenceDataStoreFactory
            .createWithPath(
                corruptionHandler = corruptionHandler,
                scope = coroutineScope,
                migrations = migrations,
                produceFile = {
                    path().toPath()
                }
            )
    }

    private val darkModeKey = booleanPreferencesKey("$PREFS_TAG_KEY$IS_DARK_MODE_ENABLED")

    /**
     * TODO Это sample, удалить, когда будут реальные префы.
     */
    suspend fun isDarkModeEnabled() = dataStore.data.map { preferences ->
        preferences[darkModeKey] ?: false
    }.first()

    /**
     * TODO Это sample, удалить, когда будут реальные префы.
     */
    suspend fun changeDarkMode(isEnabled : Boolean) = dataStore.edit { preferences ->
        preferences[darkModeKey] = isEnabled
    }
}