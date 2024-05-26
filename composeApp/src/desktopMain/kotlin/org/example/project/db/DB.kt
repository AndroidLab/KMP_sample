package org.example.project.db

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import java.io.File

/**
 * Возвращает базу данных.
 */
internal fun getDatabase(): AppDatabase {
    //val dbFile = File(System.getProperty("java.io.tmpdir"), APP_DB)  //TODO оставил, как пример получения пути к temp через System.getProperty.
    return Room.databaseBuilder<AppDatabase>(
        name = "C:\\ProgramData\\Patient Sample\\db\\${AppDatabase.APP_DB}",   //TODO Погуглить, куда указывать пути для MacOS.
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO).build()
}
