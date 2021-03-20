package ru.bk.klim9.xingtest.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import ru.bk.klim9.xingtest.requests.repos.RepoResponseItem
import ru.bk.klim9.xingtest.requests.repos.ReposItem

/**
 * @author ivan.a.klymenko@gmail.com on 3/19/21
 */
@Dao
interface DbDao {

    @Query("SELECT name, description FROM repo_items")
    fun flowRepos(): Flowable<List<ReposItem>>

//    @Query("SELECT * FROM movie")
//    fun movies(): List<Movie>
//
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(movies: List<RepoResponseItem>)
//
//    @Delete
//    fun clear(movies: List<Movie>)
//
//    @Query("SELECT * FROM movie WHERE  id = :movieId")
//    fun observeMovie(movieId: Int): Flowable<Movie>
}
