package org.example.project.second_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.jensklingenberg.ktorfit.Ktorfit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.main_screen.api.IBirdApi
import org.example.project.main_screen.data.MainScreenUiState
import org.example.project.main_screen.db.AppDatabase
import org.example.project.main_screen.db.TodoDao
import org.example.project.preferences.AppPreferences


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