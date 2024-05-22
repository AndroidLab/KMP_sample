import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

/**
 *
 */
interface ICoroutinesComponent {
    /**
     *
     */
    val mainImmediateDispatcher: CoroutineDispatcher

    /**
     *
     */
    val applicationScope: CoroutineScope
}

/**
 *
 */
internal class CoroutinesComponent private constructor() : ICoroutinesComponent {

    companion object {
        fun create(): ICoroutinesComponent = CoroutinesComponent()
    }

    override val mainImmediateDispatcher: CoroutineDispatcher = Dispatchers.Main.immediate
    override val applicationScope: CoroutineScope
        get() = CoroutineScope(
            SupervisorJob() + mainImmediateDispatcher,
        )
}