package org.example.project.preferences

/**
 * Создает предпочтения для jvm платформы.
 */
internal fun getDataStorePreferences() = AppPreferences.getAppDataStoreWithDefaults(
    path = { "C:\\ProgramData\\Patient Sample\\pref\\${AppPreferences.APP_PREF}" }
)