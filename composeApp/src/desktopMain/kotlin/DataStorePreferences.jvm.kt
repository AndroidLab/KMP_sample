import androidx.datastore.core.DataMigration
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.CoroutineScope

/**
 * Создает предпочтения для jvm платформы.
 */
actual fun createDataStorePreferences(
    corruptionHandler: ReplaceFileCorruptionHandler<Preferences>?,
    coroutineScope: CoroutineScope,
    migrations: List<DataMigration<Preferences>>
): DataStore<Preferences> = createDataStoreWithDefaults(
        corruptionHandler = corruptionHandler,
        migrations = migrations,
        coroutineScope = coroutineScope,
        path = { APP_PREFERENCES }
    )