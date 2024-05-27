package org.example.project.ui.main_screen.presentation

import androidx.compose.runtime.Composable
import org.example.project.SamGMYTheme

/**
 * Представляет главный экран приложения.
 */
@Composable
fun MainScreen() {
    SamGMYTheme {
        /*BottomNavigation(
            backgroundColor = Color.White
        ) {
            val rootController = LocalRootController.current
            Constants.BottomNavItems.forEach { bottomNavItem ->
                BottomNavigationItem(
                    selected = bottomNavItem.id == 1,
                    onClick = {
                        rootController.push("SecondScreen")
                    },
                    icon = {
                        Icon(
                            imageVector = vectorResource(bottomNavItem.drawableResource),
                            contentDescription = bottomNavItem.label
                        )
                    },
                    label = {
                        Text(text = bottomNavItem.label)
                    },
                    alwaysShowLabel = false
                )
            }
        }*/
    }
}


