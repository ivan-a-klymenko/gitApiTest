package ru.bk.klim9.movies.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.bk.klim9.xingtest.requests.repos.RepoResponse

/**
 * @author ivan.a.klymenko@gmail.com on 3/19/21
 */
@Database(entities = [RepoResponse::class], version = 1, exportSchema = false)
abstract class XingDatabase : RoomDatabase() {
    abstract fun xingDao(): XingDao
}
