package org.example.project

import androidx.compose.ui.window.ComposeUIViewController
import org.example.project.di.Koin
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import org.example.project.utils.navigationGraph

fun MainViewController() = ComposeUIViewController {
    Koin.setupKoin()
    val configuration = OdysseyConfiguration()
    setNavigationContent(configuration) {
        navigationGraph()
    }
}