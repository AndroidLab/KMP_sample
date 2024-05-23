package org.example.project.di

import org.example.project.main_screen.db.AppDatabase
import org.koin.dsl.module
import org.example.project.db.getDatabase

/**
 * Возвращает реализацию DI jvm.
 */
actual fun getPlatformDIModule() = module {
    single<AppDatabase> { getDatabase() }
}
