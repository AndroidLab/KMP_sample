import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.plus

/**
 *
 */
interface ICoreComponent : ICoroutinesComponent {
    /**
     * Возвращает настройки приложения
     */
    val appPreferences: IAppPreferences
}

internal class CoreComponent internal constructor() : ICoreComponent,
    ICoroutinesComponent by CoroutinesComponent.create() {

    private val dataStore: DataStore<Preferences> = createDataStorePreferences(
        corruptionHandler = null,
        coroutineScope = (applicationScope.plus(Dispatchers.IO)),
        migrations = emptyList()
    )

    override val appPreferences: IAppPreferences = AppPreferences(dataStore)
}