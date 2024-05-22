package org.example.project

import android.content.Context
import androidx.startup.Initializer

/**
 * Возвращает или устанавливает android контекст.
 */
internal lateinit var applicationContext: Context
    private set

/**
 * Представляет инициализатор поставщика контекста.
 */
data object ContextProviderInitializer

/**
 * Представляет поставщик android контекста.
 */
class ContextProvider: Initializer<ContextProviderInitializer> {
    override fun create(context: Context): ContextProviderInitializer {
        applicationContext = context.applicationContext
        return ContextProviderInitializer
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}