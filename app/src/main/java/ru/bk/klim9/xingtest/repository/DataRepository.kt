package ru.bk.klim9.xingtest.repository

import io.reactivex.Flowable
import io.reactivex.Single
import ru.bk.klim9.xingtest.repository.api.RemoteDataService
import ru.bk.klim9.xingtest.repository.database.DbDao
import ru.bk.klim9.xingtest.requests.repos.RepoResponse
import ru.bk.klim9.xingtest.requests.repos.ReposItem

const val OWNER = "xing"

class DataRepository(private val service: RemoteDataService, private val dbDao: DbDao) :
    IDataRepository {

    override fun observeRepos(): Flowable<List<ReposItem>> = dbDao.flowRepos()
        .flatMap {
            val repoItems = arrayListOf<ReposItem>()
            it.forEach{ repoResponseItem ->
                val owner = repoResponseItem.owner
                repoItems.add(ReposItem(repoResponseItem.name, owner.login, owner.avatarUrl, repoResponseItem.description, repoResponseItem.fork))
            }
            return@flatMap Flowable.just(repoItems)
        }

    override fun getRemoteData(): Single<RepoResponse> = service.getRemoteData(OWNER)
        .flatMap {
            dbDao.saveAll(it)
            return@flatMap Single.just(it)
        }

}
