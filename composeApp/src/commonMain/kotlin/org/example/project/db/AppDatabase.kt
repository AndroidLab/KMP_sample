package org.example.project.db

import androidx.room.Database
import androidx.room.RoomDatabase
import org.example.project.ui.main_screen.db.TodoDao
import org.example.project.ui.main_screen.db.TodoEntity

/**
 * Представляет базу данных приложения.
 */
@Database(
    entities = [
        TodoEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        /**
         * Возвращает название файла БД.
         */
        const val APP_DB = "app.db"

        const val TODO_TABLE = "todo"
    }

    abstract val todoDao: TodoDao

}