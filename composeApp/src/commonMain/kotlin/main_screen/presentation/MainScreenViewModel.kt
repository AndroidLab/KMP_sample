package main_screen.presentation

import CoreComponent
import ICoreComponent
import de.jensklingenberg.ktorfit.Ktorfit
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import main_screen.data.MainScreenUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import main_screen.api.IBirdApi
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


/**
 * Предствавляет модель представления главного экрана.
 */
class MainScreenViewModel: ViewModel(), KoinComponent {

    private val ktorfit: Ktorfit by inject()
    val coreComponent: ICoreComponent by inject()

    private val _uiState = MutableStateFlow(MainScreenUiState())
    val uiState = _uiState.asStateFlow()


    init {
        //updateImages()
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