import androidx.compose.ui.window.ComposeUIViewController
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import utils.initCoin
import utils.navigationGraph

fun MainViewController() = ComposeUIViewController {
    initCoin()
    val configuration = OdysseyConfiguration()
    setNavigationContent(configuration) {
        navigationGraph()
    }
}