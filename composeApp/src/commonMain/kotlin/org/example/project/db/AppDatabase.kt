package org.example.project.db

import androidx.room.Database
import androidx.room.RoomDatabase
import org.example.project.ui.main_screen.db.TodoDao
import org.example.project.ui.main_screen.db.TodoEntity

/**
 * Возвращает название файла БД.
 */
const val APP_DB = "app.db"

@Database(entities = [TodoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): TodoDao
}