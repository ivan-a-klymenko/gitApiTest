package ru.bk.klim9.xingtest.repository

import io.reactivex.Flowable
import io.reactivex.subscribers.TestSubscriber
import org.junit.Before
import org.junit.Test
import ru.bk.klim9.xingtest.repository.api.FakeRemoteDataService
import ru.bk.klim9.xingtest.repository.database.FakeDbDao
import ru.bk.klim9.xingtest.requests.repos.RepoResponseItem


/**
 * @author ivan.a.klymenko@gmail.com on 3/23/21
 */
class DataRepositoryTest {

    private lateinit var fakeRemoteDataService: FakeRemoteDataService
    private lateinit var fakeDbDao: FakeDbDao
    private lateinit var testSubscriber: TestSubscriber<List<RepoResponseItem>>

    @Before
    fun createRepository() {
        testSubscriber = TestSubscriber<List<RepoResponseItem>>()
        fakeRemoteDataService = FakeRemoteDataService()
        fakeDbDao = FakeDbDao(SourceProducer.getFullRepoResponse())
    }

    @Test
    fun observeRepos_fullList() {
        fakeDbDao.flowRepos().subscribe(testSubscriber)

        testSubscriber.assertComplete()
        testSubscriber.assertNoErrors()
    }

    @Test
    fun observeRepos_error() {
        fakeDbDao.flowRepos()
            .flatMap {
                return@flatMap Flowable.error<List<RepoResponseItem>>(RuntimeException("error in observeRepos"))
            }
            .subscribe(testSubscriber)

        testSubscriber.assertError(RuntimeException::class.java)
        testSubscriber.assertNotComplete()
    }
}