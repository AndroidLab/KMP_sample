class JVMPlatform: Platform {
    override val name = "Java ${System.getProperty("java.version")}"
    override val type = Platform.Type.DESKTOP
}

actual fun getPlatform(): Platform = JVMPlatform()
