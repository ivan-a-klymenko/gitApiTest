package ru.bk.klim9.xingtest.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.bk.klim9.xingtest.requests.repos.RepoResponseItem

/**
 * @author ivan.a.klymenko@gmail.com on 3/19/21
 */
@TypeConverters(TypeConverter::class)
@Database(entities = [RepoResponseItem::class], version = 1, exportSchema = false)
abstract class XingDatabase : RoomDatabase() {
    abstract fun xingDao(): XingDao
}
