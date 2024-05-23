package org.example.project

import androidx.datastore.core.DataMigration
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.CoroutineScope
import org.example.project.APP_PREFERENCES
import org.example.project.applicationContext
import org.example.project.createDataStoreWithDefaults
import java.io.File

/**
 * Создает реализации предпочтений для android.
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
        File(applicationContext.filesDir, "datastore/$APP_PREFERENCES").path
    }
)