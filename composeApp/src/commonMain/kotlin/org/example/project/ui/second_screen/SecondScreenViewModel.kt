package org.example.project.ui.second_screen

import androidx.lifecycle.ViewModel


/**
 * Предствавляет модель представления главного экрана.
 */
class SecondScreenViewModel(): ViewModel() {

    init {
        println("AAAAAAA Second init")

    }

    override fun onCleared() {
        super.onCleared()
        println("AAAAAAA Second on cleared")
    }

}