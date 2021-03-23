package ru.bk.klim9.xingtest.repository.api

import io.reactivex.Single
import ru.bk.klim9.xingtest.requests.repos.RepoResponse

/**
 * @author ivan.a.klymenko@gmail.com on 3/23/21
 */
class FakeRemoteDataService(val repoResponse: RepoResponse) : RemoteDataService{

    override fun getRemoteData(owner: String): Single<RepoResponse> {
        TODO("Not yet implemented")
    }
}