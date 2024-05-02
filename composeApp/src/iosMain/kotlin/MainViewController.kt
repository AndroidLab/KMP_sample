import androidx.compose.ui.window.ComposeUIViewController
import main_screen.presentation.MainScreen
import utils.initCoin

fun MainViewController() = ComposeUIViewController {
    initCoin()
    MainScreen()
}