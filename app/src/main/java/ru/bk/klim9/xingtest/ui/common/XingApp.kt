package ru.bk.klim9.xingtest.ui.common;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import ru.bk.klim9.xingtest.di.ApplicationComponent;
import ru.bk.klim9.xingtest.di.DaggerApplicationComponent;
import ru.bk.klim9.xingtest.repository.database.DatabaseHolder;

/**
 * @author ivan.a.klymenko@gmail.com on 2019-12-08
 */
public class XingApp extends BaseApplication {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        applicationComponent = DaggerApplicationComponent.builder().application(this).build();
        super.onCreate();
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
