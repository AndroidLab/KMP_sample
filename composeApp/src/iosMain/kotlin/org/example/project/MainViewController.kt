package org.example.project

import androidx.compose.ui.window.ComposeUIViewController
import org.example.project.di.AppKoin
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import org.example.project.utils.navigationGraph

/**
 * Представляет точку входа в ios приложение.
 */
fun MainViewController() = ComposeUIViewController {
    AppKoin.setupKoin()
    val configuration = OdysseyConfiguration()
    setNavigationContent(configuration) {
        navigationGraph()
    }
}