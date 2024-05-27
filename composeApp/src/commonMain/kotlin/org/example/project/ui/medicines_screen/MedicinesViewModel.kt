package org.example.project.ui.medicines_screen

import androidx.lifecycle.ViewModel


/**
 * Предствавляет модель представления главного экрана.
 */
class MedicinesViewModel(): ViewModel() {

    init {
        println("AAAAAAA Second init")

    }

    override fun onCleared() {
        super.onCleared()
        println("AAAAAAA Second on cleared")
    }

}