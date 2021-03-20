package ru.bk.klim9.xingtest.ui.common;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import ru.bk.klim9.xingtest.database.DatabaseHolder;
import ru.bk.klim9.xingtest.di.ApplicationComponent;
import ru.bk.klim9.xingtest.di.DaggerApplicationComponent;

/**
 * @author ivan.a.klymenko@gmail.com on 2019-12-08
 */
public class XingApp extends BaseApplication {

    private static XingApp instance;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        applicationComponent = DaggerApplicationComponent.builder().application(this).build();
        instance = this;
        super.onCreate();
    }

    public static XingApp getInstance() {
        return instance;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return applicationComponent;
    }

    @Override
    protected void initDataBase() {
        DatabaseHolder.INSTANCE.init(this);
    }

}
