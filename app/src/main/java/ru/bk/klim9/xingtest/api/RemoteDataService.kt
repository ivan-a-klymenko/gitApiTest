package ru.bk.klim9.xingtest.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.bk.klim9.xingtest.requests.repos.RepoResponse

/**
 * @author ivan.a.klymenko@gmail.com on 3/19/21
 */

interface RemoteDataService {

    @GET("orgs/{owner}/repos")
    fun getRemoteData(@Path("owner") owner: String): Single<RepoResponse>


}
