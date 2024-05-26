package org.example.project.preferences

import android.content.Context
import java.io.File

/**
 * Создает реализации предпочтений для android.
 * @param context Контекст приложения.
 */
internal fun getDataStorePreferences(context: Context) = AppPreferences.getAppDataStoreWithDefaults(
    path = {
        File(context.filesDir, "pref/${AppPreferences.APP_PREF}").path
    }
)