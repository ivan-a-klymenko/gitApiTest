package ru.bk.klim9.xingtest.ui.common

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * @author Ivan
 */
abstract class BaseApplication : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
        initDataBase()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return null
    }

    protected abstract fun initDataBase()
}