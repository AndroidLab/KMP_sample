import androidx.datastore.core.DataMigration
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.CoroutineScope
import org.example.project.applicationContext
import java.io.File

/**
 * Ожидает реализации создания предпочтений для конкретной платформы.
 */
actual fun createDataStorePreferences(
    corruptionHandler: ReplaceFileCorruptionHandler<Preferences>?,
    coroutineScope: CoroutineScope,
    migrations: List<DataMigration<Preferences>>
) = createDataStoreWithDefaults(
    corruptionHandler = corruptionHandler,
    migrations = migrations,
    coroutineScope = coroutineScope,
    path = {
        File(applicationContext.filesDir, "datastore/$SETTINGS_PREFERENCES").path
    }
)