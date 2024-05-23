package org.example.project.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.example.project.preferences.APP_PREFERENCES
import org.example.project.preferences.createDataStoreWithDefaults
import org.example.project.db.getDatabase
import org.example.project.main_screen.db.AppDatabase
import org.example.project.preferences.getDataStorePreferences
import org.koin.dsl.module

/**
 * Возвращает реализацию DI ios.
 */
actual fun getPlatformDIModule() = module {
    /**
     * Возвращает базу данных.
     */
    single<AppDatabase> { getDatabase() }

    /**
     * Возвращает предпочтения.
     */
    single<DataStore<Preferences>> {
        getDataStorePreferences()
    }
}
