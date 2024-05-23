package org.example.project.main_screen.data.models

import kotlinx.serialization.Serializable

@Serializable
data class BirdModel(
    val author: String,
    val category: String,
    val path: String
)