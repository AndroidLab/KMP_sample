package main_screen.data

import main_screen.data.models.BirdModel

/**
 * Представляет состояние главного экрана.
 */
data class MainScreenUiState(
    val images: List<BirdModel> = emptyList(),
    val selectedCategory: String? = null
) {
    val categories = images.map { it.category }.toSet()
    val selectedImages = images.filter { it.category == selectedCategory }
}