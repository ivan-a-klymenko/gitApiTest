package ru.bk.klim9.xingtest.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ru.bk.klim9.xingtest.ui.repos.ReposFragment
import ru.bk.klim9.xingtest.ui.repos.ReposViewModel

/**
 * @author ivan.a.klymenko@gmail.com on 2019-12-13
 */
@Suppress("unused")
@Module
abstract class ReposModule {

    @ContributesAndroidInjector
    abstract fun contributesReposFragment(): ReposFragment

    @Binds
    @IntoMap
    @ViewModelKey(ReposViewModel::class)
    abstract fun bindsReposViewModel(moviesViewModel: ReposViewModel): ViewModel
}