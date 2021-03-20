package ru.bk.klim9.xingtest.di.modules

import dagger.Module
import dagger.Provides
import ru.bk.klim9.movies.api.XingService
import ru.bk.klim9.xingtest.api.ApiFactory
import ru.bk.klim9.xingtest.database.DatabaseHolder
import ru.bk.klim9.xingtest.database.XingDao
import ru.bk.klim9.xingtest.repository.DataRepository
import javax.inject.Singleton

@Suppress("unused")
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideSiteSpecsRepository(api: XingService, xingDao: XingDao) =
        DataRepository(api, xingDao)

    @Singleton
    @Provides
    fun provideMoviesService() : XingService {
        return ApiFactory.moviesService
    }

    @Singleton
    @Provides
    fun provideMoviesDao(): XingDao {
        return DatabaseHolder.database().xingDao()
    }
}