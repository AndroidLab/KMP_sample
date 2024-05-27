import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.example.project.di.AppKoin
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import org.example.project.navigation.navigationGraph

/**
 * Представляет точку входа в desktop приложение.
 */
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Patient",
        state = rememberWindowState(
            width = 1280.dp,
            height = 1024.dp,
            position = WindowPosition.Aligned(Alignment.Center)
        )
    ) {
        AppKoin.setupKoin()
        val configuration = OdysseyConfiguration()
        setNavigationContent(configuration, onApplicationFinish = {
            exitApplication()
        }) {
            navigationGraph()
        }
    }
}