package org.example.project.preferences

/**
 * Создает предпочтения для jvm платформы.
 */
internal fun getDataStorePreferences() = AppPreferences.getAppDataStoreWithDefaults(
    path = { AppPreferences.APP_PREFERENCES }
)