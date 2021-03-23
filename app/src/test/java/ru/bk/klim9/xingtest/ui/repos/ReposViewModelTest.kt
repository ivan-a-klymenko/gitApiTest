package ru.bk.klim9.xingtest.ui.repos

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.not
import org.hamcrest.Matchers.nullValue
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.bk.klim9.xingtest.requests.repos.ReposItem

/**
 * @author ivan.a.klymenko@gmail.com on 3/22/21
 */
@RunWith(AndroidJUnit4::class)
class ReposViewModelTest {

    private lateinit var reposViewModel: ReposViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        reposViewModel = ReposViewModel()
    }


    @Test
    fun setReposValue_setsFullList() {

        val testFullList = createFullList()

        val observer = Observer<ReposViewModel.Action> {}
        try {
            reposViewModel.reposLd.observeForever(observer)
            reposViewModel.setReposValue(testFullList)
            val value = reposViewModel.reposLd.value
            assertThat(getUndirectedData(value), not(nullValue()))
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
            assertThat(getUndirectedData(value), not(nullValue()))
        } finally {
            reposViewModel.reposLd.removeObserver(observer)
        }
    }

    private fun getUndirectedData(value: ReposViewModel.Action?): List<ReposItem>? {
        return if (value is ReposViewModel.Action.Repos) {
            value.reposList
        } else null
    }

    private fun createFullList(): List<ReposItem> = arrayListOf<ReposItem>().apply {
        add(ReposItem("TestName1", "OwnerLogin1", "ownerLogo1", "description1", true))
        add(ReposItem("TestName2", "OwnerLogin2", "ownerLogo2", "description2", true))
        add(ReposItem("TestName3", "OwnerLogin3", "ownerLogo3", "description3", true))
        add(ReposItem("TestName4", "OwnerLogin4", "ownerLogo4", "description4", true))

    }
}