package org.example.project.preferences

/**
 * Создает предпочтения для io платформы.
 */
internal fun getDataStorePreferences() = AppPreferences.getAppDataStoreWithDefaults(
    path = {
        val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
        (requireNotNull(documentDirectory).path + "/${AppPreferences.APP_PREFERENCES}")
    }
)