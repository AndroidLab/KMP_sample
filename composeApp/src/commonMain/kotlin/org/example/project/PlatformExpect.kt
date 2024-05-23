package org.example.project

/**
 * Описывает свойства и методы платформы.
 */
interface Platform {
    /**
     * Возвращает имя платформы.
     */
    val name: String

    /**
     * Возвращает тип платформы.
     */
    val type: Type

    /**
     * Перечисляет типы платформы.
     */
    enum class Type {
        ANDROID,
        DESKTOP,
        IOS
    }
}

/**
 * Ожидает реализации конкретных платформ.
 */
expect fun getPlatform(): Platform
