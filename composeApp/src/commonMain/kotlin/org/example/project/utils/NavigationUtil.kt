package org.example.project.utils

import org.example.project.di.AppKoin
import org.example.project.ui.bluetooth_screen.BluetoothScreen
import org.example.project.ui.bluetooth_screen.BluetoothScreenViewModel
import org.example.project.ui.main_screen.presentation.MainScreen
import org.example.project.ui.main_screen.presentation.MainScreenViewModel
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import org.example.project.ui.second_screen.SecondScreen
import org.example.project.ui.second_screen.SecondScreenViewModel

/**
 *
 */
fun RootComposeBuilder.navigationGraph() {
    screen("MainScreen") { MainScreen(AppKoin.di.get<MainScreenViewModel>()) }
    screen("SecondScreen") { SecondScreen(AppKoin.di.get<SecondScreenViewModel>()) }
    screen("BluetoothScreen") { BluetoothScreen(AppKoin.di.get<BluetoothScreenViewModel>()) }
}