package org.example.project.di

import org.example.project.db.getDatabase
import org.example.project.main_screen.db.AppDatabase
import org.koin.dsl.module

/**
 * Возвращает реализацию DI ios.
 */
actual fun getPlatformDIModule() = module {
    single<AppDatabase> { getDatabase() }
}
