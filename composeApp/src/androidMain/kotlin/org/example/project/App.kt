package org.example.project

import android.app.Application
import utils.initCoin

/**
 * Представляет класс приложения.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ApplicationComponent.init()
        initCoin()
    }
}