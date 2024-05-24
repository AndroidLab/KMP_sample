package org.example.project.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.example.project.db.getDatabase
import org.example.project.db.AppDatabase
import org.example.project.preferences.getDataStorePreferences
import org.koin.dsl.module

/**
 * Возвращает реализацию DI android.
 */
actual fun getPlatformDIModule() = module {
    /**
     * Возвращает базу данных.
     */
    single<AppDatabase> { getDatabase(context = get()) }

    /**
     * Возвращает предпочтения.
     */
    single<DataStore<Preferences>> {
        getDataStorePreferences(context = get())
    }
}
