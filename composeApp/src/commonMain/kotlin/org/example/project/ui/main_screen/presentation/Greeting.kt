package org.example.project.ui.main_screen.presentation

import org.example.project.IPlatform
import org.example.project.di.AppKoin

class Greeting {
    private val platform: IPlatform = AppKoin.di.get()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}