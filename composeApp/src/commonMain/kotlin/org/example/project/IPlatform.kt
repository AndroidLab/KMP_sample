package org.example.project

/**
 * Описывает свойства и методы платформы.
 */
interface IPlatform {
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

    companion object {
        operator fun invoke(
            name: String,
            type: Type
        ): IPlatform = object : IPlatform {
            override val name = name
            override val type = type
        }
    }
}
