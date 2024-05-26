package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import org.example.project.utils.navigationGraph

/**
 * Представляет точку входа в android приложение.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val configuration = OdysseyConfiguration(canvas = this)
            setNavigationContent(configuration) {
                navigationGraph()
            }
        }
    }
}