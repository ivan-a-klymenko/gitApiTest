package ru.bk.klim9.xingtest.repository

import io.reactivex.Flowable
import io.reactivex.Single
import ru.bk.klim9.xingtest.requests.repos.RepoResponse
import ru.bk.klim9.xingtest.requests.repos.ReposItem

/**
 * @author ivan.a.klymenko@gmail.com on 3/23/21
 */
class FakeDataRepository : IDataRepository {

    override fun observeRepos(): Flowable<List<ReposItem>> = Flowable.just(SourceProducer.createFulReposItemlList())

    override fun getRemoteData(): Single<RepoResponse> = Single.just(SourceProducer.getFullRepoResponse())
}