package org.example.project.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.example.project.IPlatform
import org.example.project.db.AppDatabase
import org.koin.dsl.module
import org.example.project.db.getDatabase
import org.example.project.preferences.getDataStorePreferences

/**
 * Возвращает реализацию DI jvm.
 */
actual fun getPlatformDIModule() = module {
    /**
     * Возвращает данные платформы.
     */
    single {
        IPlatform(
            name = "Java ${System.getProperty("java.version")}",
            type = IPlatform.Type.DESKTOP
        )
    }
    /**
     * Возвращает базу данных.
     */
    single<AppDatabase> { getDatabase() }

    /**
     * Возвращает предпочтения.
     */
    single<DataStore<Preferences>> { getDataStorePreferences() }
}
