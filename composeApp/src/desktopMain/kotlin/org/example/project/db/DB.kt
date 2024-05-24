package org.example.project.db

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import java.io.File

/**
 * Возвращает базу данных.
 */
internal fun getDatabase(): AppDatabase {
    val dbFile = File(System.getProperty("java.io.tmpdir"), APP_DB)
    return Room.databaseBuilder<AppDatabase>(
        name = dbFile.absolutePath,
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO).build()
}
