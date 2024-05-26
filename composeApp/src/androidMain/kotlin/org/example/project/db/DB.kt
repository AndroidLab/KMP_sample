package org.example.project.db

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers

/**
 * Возвращает базу данных.
 * @param context Контекст приложения.
 */
internal fun getDatabase(context: Context) = Room.databaseBuilder<AppDatabase>(
    context = context,
    name = context.getDatabasePath(AppDatabase.APP_DB).absolutePath
).setDriver(BundledSQLiteDriver())
    .setQueryCoroutineContext(Dispatchers.IO).build()
