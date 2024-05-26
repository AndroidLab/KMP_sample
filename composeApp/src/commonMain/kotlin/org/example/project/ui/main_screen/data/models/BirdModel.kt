package org.example.project.ui.main_screen.data.models

import kotlinx.serialization.Serializable


/**
 * TODO Для сэмпла.
 */
@Serializable
data class BirdModel(
    val author: String,
    val category: String,
    val path: String
)