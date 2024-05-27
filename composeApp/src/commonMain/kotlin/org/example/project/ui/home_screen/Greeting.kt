package org.example.project.ui.home_screen

import org.example.project.IPlatform
import org.example.project.di.AppKoin

class Greeting {
    private val platform: IPlatform = AppKoin.di.get()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}