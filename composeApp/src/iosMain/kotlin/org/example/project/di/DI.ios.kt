package org.example.project.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.example.project.IPlatform
import org.example.project.db.getDatabase
import org.example.project.db.AppDatabase
import org.example.project.preferences.getDataStorePreferences
import org.koin.dsl.module

/**
 * Возвращает реализацию DI ios.
 */
actual fun getPlatformDIModule() = module {
    /**
     * Возвращает данные платформы.
     */
    single {
        IPlatform(
            name = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion,
            type = IPlatform.Type.IOS
        )
    }
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
