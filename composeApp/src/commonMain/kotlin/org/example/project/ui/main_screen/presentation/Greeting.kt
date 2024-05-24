package org.example.project.ui.main_screen.presentation

import org.example.project.getPlatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}