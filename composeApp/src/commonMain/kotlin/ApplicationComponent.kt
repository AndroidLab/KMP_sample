/**
 *
 */
object ApplicationComponent {
    private var _coreComponent: ICoreComponent? = null

    /**
     *
     */
    val coreComponent
        get() = _coreComponent
            ?: throw IllegalStateException("Make sure to call ApplicationComponent.init()")

    fun init() {
        _coreComponent = CoreComponent()
    }
}

/**
 *
 */
val coreComponent
    get() = ApplicationComponent.coreComponent