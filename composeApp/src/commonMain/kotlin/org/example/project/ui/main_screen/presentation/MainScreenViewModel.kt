package org.example.project.ui.main_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.jensklingenberg.ktorfit.Ktorfit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.example.project.ui.main_screen.api.IBirdApi
import org.example.project.ui.main_screen.data.MainScreenUiState
import org.example.project.db.AppDatabase
import org.example.project.ui.main_screen.db.TodoDao
import org.example.project.preferences.AppPreferences


/**
 * Предствавляет модель представления главного экрана.
 */
class MainScreenViewModel(
    private val ktorfit: Ktorfit,
    private val database: AppDatabase,
    private val preferences: AppPreferences
): ViewModel() {

    private val _uiState = MutableStateFlow(MainScreenUiState())
    val uiState = _uiState.asStateFlow()

    val titleText: MutableStateFlow<String> = MutableStateFlow("")

    private val dao: TodoDao by lazy {
        database.getDao()
    }

    init {
        println("AAAAAAA Main init")
        viewModelScope.launch {
            preferences.changeDarkMode(true)
        }
    }

    override fun onCleared() {
        super.onCleared()
        println("AAAAAAA Main on cleared")
    }

    fun selectCategory(category: String) {
        _uiState.update {
            it.copy(selectedCategory = category)
        }
    }

    private fun updateImages() {
        viewModelScope.launch(Dispatchers.IO) {
            val images = getImages()
            _uiState.update {
                it.copy(images = images)
            }
        }
    }

    private suspend fun getImages() = ktorfit.create<IBirdApi>().getBirds()
}