package utils

import di.appModule
import org.koin.core.context.startKoin

/**
 * Инициализирует [Coin].
 */
fun initCoin() {
    startKoin {
        modules(appModule)
    }
}