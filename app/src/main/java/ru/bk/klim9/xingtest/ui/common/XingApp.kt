package ru.bk.klim9.xingtest.ui.common

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import ru.bk.klim9.xingtest.di.ApplicationComponent
import ru.bk.klim9.xingtest.di.DaggerApplicationComponent
import ru.bk.klim9.xingtest.repository.database.DatabaseHolder.init

/**
 * @author ivan.a.klymenko@gmail.com on 2019-12-08
 */
class XingApp : BaseApplication() {
    private var applicationComponent: ApplicationComponent? = null
    override fun onCreate() {
        applicationComponent = DaggerApplicationComponent.builder().application(this).build()
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication?>? {
        return applicationComponent
    }

    override fun initDataBase() {
        init(this)
    }
}