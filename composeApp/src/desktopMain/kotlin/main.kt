import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import main_screen.presentation.MainScreen
import utils.initCoin

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KotlinProject",
    ) {
        initCoin()
        MainScreen()
    }
}