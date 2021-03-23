package ru.bk.klim9.xingtest.repository.database

import android.content.Context

import androidx.annotation.MainThread
import androidx.room.Room

/**
 * @author ivan.a.klymenko@gmail.com on 3/19/21
 */
object DatabaseHolder {

    private lateinit var database: XingDatabase

    @MainThread
    fun init(context: Context) {
        database = Room.databaseBuilder(
            context.applicationContext,
            XingDatabase::class.java,
            "xing-database"
        ).build()
    }

    fun database(): XingDatabase {
        return database
    }
}
