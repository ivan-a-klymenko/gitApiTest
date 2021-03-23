package ru.bk.klim9.xingtest.ui.repos

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import ru.bk.klim9.xingtest.repository.FakeDataRepository
import ru.bk.klim9.xingtest.repository.IDataRepository
import ru.bk.klim9.xingtest.repository.SourceProducer
import ru.bk.klim9.xingtest.requests.repos.ReposItem

/**
 * @author ivan.a.klymenko@gmail.com on 3/23/21
 */
@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class ReposViewModelTest {

    private lateinit var reposViewModel: ReposViewModel
    private lateinit var repository: IDataRepository

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        reposViewModel = ReposViewModel()
        repository = FakeDataRepository()
    }


    @Test
    fun setReposValue_setsFullList() {

        val testFullList = SourceProducer.createFulReposItemlList()

        val observer = Observer<ReposViewModel.Action> {}
        try {
            reposViewModel.reposLd.observeForever(observer)
            reposViewModel.setReposValue(testFullList)
            val value = reposViewModel.reposLd.value
            assertThat(getUndirectedData(value), Matchers.not(Matchers.nullValue()))
        } finally {
            reposViewModel.reposLd.removeObserver(observer)
        }
    }

    @Test
    fun setReposValue_setsEmptyList() {

        val testEmptyList = listOf<ReposItem>()

        val observer = Observer<ReposViewModel.Action> {}
        try {
            reposViewModel.reposLd.observeForever(observer)
            reposViewModel.setReposValue(testEmptyList)
            val value = reposViewModel.reposLd.value
            assertThat(getUndirectedData(value), Matchers.not(Matchers.nullValue()))
        } finally {
            reposViewModel.reposLd.removeObserver(observer)
        }
    }

    private fun getUndirectedData(value: ReposViewModel.Action?): List<ReposItem>? {
        return if (value is ReposViewModel.Action.Repos) {
            value.reposList
        } else null
    }

    @After
    fun checkIn() {

    }

}