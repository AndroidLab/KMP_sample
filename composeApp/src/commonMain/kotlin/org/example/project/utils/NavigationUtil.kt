package org.example.project.utils

import org.example.project.di.Koin
import org.example.project.main_screen.presentation.MainScreen
import org.example.project.main_screen.presentation.MainScreenViewModel
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import org.example.project.second_screen.SecondScreen
import org.example.project.second_screen.SecondScreenViewModel

/**
 *
 */
fun RootComposeBuilder.navigationGraph() {
    screen("MainScreen") { MainScreen(Koin.di.get<MainScreenViewModel>()) }
    screen("SecondScreen") { SecondScreen(Koin.di.get<SecondScreenViewModel>()) }
}