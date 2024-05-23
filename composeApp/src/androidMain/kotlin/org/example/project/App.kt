package org.example.project

import android.app.Application
import org.example.project.di.Koin
import org.koin.android.ext.koin.androidContext

/**
 * Представляет класс приложения.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Koin.setupKoin {
            androidContext(applicationContext)
        }
    }
}