package ru.bk.klim9.xingtest.repository

import io.reactivex.Single
import ru.bk.klim9.xingtest.api.RemoteDataService
import ru.bk.klim9.xingtest.database.DbDao
import ru.bk.klim9.xingtest.requests.repos.RepoResponse

private const val TAG = "DataRepository"

const val OWNER = "xing"

class DataRepository(private val service: RemoteDataService, private val dbDao: DbDao) {

//    fun observeRepos(): Flowable<List<ReposItem>> = dbDao.flowRepos()

    fun getRemoteData(): Single<RepoResponse> = service.getRemoteData(OWNER)

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
