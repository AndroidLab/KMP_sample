package org.example.project.ui.main_screen.db

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * TODO Для сэмпла.
 */
@Entity
data class TodoEntity(
    val title: String,
    val content: String,
    val date: String,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)