package ru.bk.klim9.xingtest.ui.repos

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.reactivex.Single
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.annotation.Config
import ru.bk.klim9.xingtest.repository.IDataRepository
import ru.bk.klim9.xingtest.repository.SourceProducer
import ru.bk.klim9.xingtest.requests.repos.ReposItem

/**
 * @author ivan.a.klymenko@gmail.com on 3/23/21
 */

private const val TAG = "ReposViewModelTest"

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class ReposViewModelTest {

    private lateinit var reposViewModel: ReposViewModel
    @Mock
    private lateinit var repository: IDataRepository

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        MockitoAnnotations.initMocks(this)
        reposViewModel = ReposViewModel(repository)
    }

    @Test
    fun getRemoteData_error() {

        Mockito.`when`(repository.getRemoteData()).thenReturn(Single.error(Throwable("TTT 17")))



        val observer = Observer<ReposViewModel.Action> {}
        try {
            reposViewModel.errorLd.observeForever(observer)
            reposViewModel.getRemoteData()
            val value = reposViewModel.errorLd.value
            assertEquals(value, ReposViewModel.Action.Error("TTT 17"))
        } finally {
            reposViewModel.reposLd.removeObserver(observer)
        }

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