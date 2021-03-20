package ru.bk.klim9.xingtest.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.bk.klim9.xingtest.di.modules.DaggerViewModelInjectionModule
import ru.bk.klim9.xingtest.di.modules.ReposModule
import ru.bk.klim9.xingtest.di.modules.RepositoryModule
import ru.bk.klim9.xingtest.ui.common.XingApp
import javax.inject.Singleton

/**
 * @author Ivan
 */
@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        RepositoryModule::class,
        DaggerViewModelInjectionModule::class,
        ReposModule::class]
)
interface ApplicationComponent : AndroidInjector<XingApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}