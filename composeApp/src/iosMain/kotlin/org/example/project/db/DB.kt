package org.example.project.db

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

/**
 * Возвращает базу данных.
 */
fun getDatabase(): RoomDatabase.Builder<AppDatabase> {
    val dbFilePath = NSHomeDirectory() + "/$APP_DB"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFilePath,
        factory =  { AppDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO).build()
}
