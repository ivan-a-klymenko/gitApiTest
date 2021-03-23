package ru.bk.klim9.xingtest.repository.database

import io.reactivex.Flowable
import ru.bk.klim9.xingtest.requests.repos.RepoResponseItem

/**
 * @author ivan.a.klymenko@gmail.com on 3/23/21
 */
class FakeDbDao : DbDao {

    override fun flowRepos(): Flowable<List<RepoResponseItem>> {
        TODO("Not yet implemented")
    }

    override fun saveAll(movies: List<RepoResponseItem>) {
        TODO("Not yet implemented")
    }
}