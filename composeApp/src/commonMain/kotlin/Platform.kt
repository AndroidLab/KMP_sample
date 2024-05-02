interface Platform {
    val name: String
    val type: Type

    enum class Type {
        ANDROID,
        DESKTOP,
        IOS
    }
}

expect fun getPlatform(): Platform
