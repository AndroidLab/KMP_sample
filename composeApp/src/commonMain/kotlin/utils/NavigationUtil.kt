package utils

import main_screen.presentation.MainScreen
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import second_screen.SecondScreen

fun RootComposeBuilder.navigationGraph() {
    screen("MainScreen") { MainScreen() }
    screen("SecondScreen") { SecondScreen() }
}