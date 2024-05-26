package org.example.project.preferences

/**
 * Создает предпочтения для jvm платформы.
 */
internal fun getDataStorePreferences() = AppPreferences.getAppDataStoreWithDefaults(
    path = { AppPreferences.APP_PREFERENCES }
    //path = { "C:\\Program Files\\Patient Sample" + AppPreferences.APP_PREFERENCES }
    //path = { "${System.getProperty("user.home") + "/Desktop/"}${AppPreferences.APP_PREFERENCES}" }
)