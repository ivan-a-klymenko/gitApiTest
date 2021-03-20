package ru.bk.klim9.xingtest.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import ru.bk.klim9.xingtest.requests.repos.RepoResponseItem

/**
 * @author ivan.a.klymenko@gmail.com on 3/19/21
 */
@Dao
interface DbDao {

    @Query("SELECT * FROM repo_items")
    fun flowRepos(): Flowable<List<RepoResponseItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(movies: List<RepoResponseItem>)

}
