package org.example.project.ui.main_screen.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class TodoEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val content: String,
    val date: String
)