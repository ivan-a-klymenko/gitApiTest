package ru.bk.klim9.xingtest.repository

import ru.bk.klim9.movies.api.XingService
import ru.bk.klim9.xingtest.database.XingDao

private const val TAG = "DataRepository"

class DataRepository(private val service: XingService, private val moviesDao: XingDao) {

//    fun popularMovies(): Observable<List<Movie>> {
//        return service.popularMovies()
//            .map{ it.movies }
//            .doOnNext { movies ->
//                val currentMovies = moviesDao.movies()
//                moviesDao.clear(currentMovies)
//                moviesDao.saveAll(movies)
//            }
//            .onErrorResumeNext{t: Throwable ->
//                Log.d(TAG, "popularMovies error: ${t.message}", t)
//                val movies = moviesDao.movies()
//                Observable.just(movies)
//            }
//    }
//
//    fun observeMovie(movieId: Int): Flowable<Movie> {
//        return moviesDao.observeMovie(movieId)
//    }
}
