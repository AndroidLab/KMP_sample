package org.example.project.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.emk
import kotlinproject.composeapp.generated.resources.home
import kotlinproject.composeapp.generated.resources.journal
import kotlinproject.composeapp.generated.resources.measurements
import kotlinproject.composeapp.generated.resources.medicines
import org.example.project.di.AppKoin
import org.example.project.ui.home_screen.HomeScreen
import org.example.project.ui.medicines_screen.MedicinesScreen
import org.jetbrains.compose.resources.painterResource
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.BottomNavConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabItem
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabsNavModel

/**
 *
 */
fun RootComposeBuilder.navigationGraph() {
    //screen("TestScreen") { TestScreen(AppKoin.di.get()) }
    //screen("SecondScreen") { SecondScreen(AppKoin.di.get()) }
    //screen("BluetoothScreen") { BluetoothScreen(AppKoin.di.get()) }

    mainScreen()
}

private fun RootComposeBuilder.mainScreen() {
    bottomNavigation(name = "TestScreen", tabsNavModel = BottomConfiguration()) {
        tab(
            tabItem = HomeScreenTab()
        ) {
            screen(name = HomeScreenTab.ROUTE) {
                HomeScreen(AppKoin.di.get())
            }
        }
        tab(
            tabItem = MedicinesScreenTab()
        ) {
            screen(name = MedicinesScreenTab.ROUTE) {
                MedicinesScreen(AppKoin.di.get())
            }
        }
        tab(
            tabItem = JournalScreenTab()
        ) {
            screen(name = JournalScreenTab.ROUTE) {
                MedicinesScreen(AppKoin.di.get())
            }
        }
        tab(
            tabItem = MeasurementsScreenTab()
        ) {
            screen(name = MeasurementsScreenTab.ROUTE) {
                MedicinesScreen(AppKoin.di.get())
            }
        }
        tab(
            tabItem = EmkScreenTab()
        ) {
            screen(name = EmkScreenTab.ROUTE) {
                MedicinesScreen(AppKoin.di.get())
            }
        }
    }
}

private val titleStyle = TextStyle(
    fontSize = 10.sp,
    fontWeight = FontWeight.Normal,
)

private class HomeScreenTab : TabItem() {
    companion object {
        const val ROUTE = "HomeScreen"
    }

    override val configuration: TabConfiguration
        @Composable
        get() {
            return TabConfiguration(
                title = "Главная",
                selectedIcon = painterResource(Res.drawable.home),
                unselectedIcon = painterResource(Res.drawable.home),
                titleStyle = titleStyle
            )
        }
}

private class MedicinesScreenTab : TabItem() {
    companion object {
        const val ROUTE = "MedicinesScreen"
    }

    override val configuration: TabConfiguration
        @Composable
        get() {
            return TabConfiguration(
                title = "Лекарства",
                selectedIcon = painterResource(Res.drawable.medicines),
                unselectedIcon = painterResource(Res.drawable.medicines),
                titleStyle = titleStyle
            )
        }
}

private class JournalScreenTab : TabItem() {
    companion object {
        const val ROUTE = "JournalScreen"
    }

    override val configuration: TabConfiguration
        @Composable
        get() {
            return TabConfiguration(
                title = "Дневник",
                selectedIcon = painterResource(Res.drawable.journal),
                unselectedIcon = painterResource(Res.drawable.journal),
                titleStyle = titleStyle
            )
        }
}

private class MeasurementsScreenTab : TabItem() {
    companion object {
        const val ROUTE = "MeasurementsScreen"
    }

    override val configuration: TabConfiguration
        @Composable
        get() {
            return TabConfiguration(
                title = "Измерения",
                selectedIcon = painterResource(Res.drawable.measurements),
                unselectedIcon = painterResource(Res.drawable.measurements),
                titleStyle = titleStyle
            )
        }
}

private class EmkScreenTab : TabItem() {
    companion object {
        const val ROUTE = "EmkScreen"
    }

    override val configuration: TabConfiguration
        @Composable
        get() {
            return TabConfiguration(
                title = "ЭМК",
                selectedIcon = painterResource(Res.drawable.emk),
                unselectedIcon = painterResource(Res.drawable.emk),
                titleStyle = titleStyle
            )
        }
}


private class BottomConfiguration : TabsNavModel<BottomNavConfiguration>() {
    override val navConfiguration: BottomNavConfiguration
        @Composable
        get() {
            return BottomNavConfiguration(
                backgroundColor = Color.White,
                selectedColor = Color(0xFF27C6DA),
                unselectedColor = Color(0xFF9898a6),
            )
        }
}