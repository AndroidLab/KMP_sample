package org.example.project.preferences

import android.content.Context
import java.io.File

/**
 * Создает реализации предпочтений для android.
 */
internal fun getDataStorePreferences(context: Context) = AppPreferences.getAppDataStoreWithDefaults(
    path = {
        File(context.filesDir, "datastore/${AppPreferences.APP_PREF}").path
    }
)