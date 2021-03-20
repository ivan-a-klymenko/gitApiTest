package ru.bk.klim9.xingtest.di.modules

import dagger.Module
import dagger.Provides
import ru.bk.klim9.xingtest.api.ApiFactory
import ru.bk.klim9.xingtest.api.RemoteDataService
import ru.bk.klim9.xingtest.database.DatabaseHolder
import ru.bk.klim9.xingtest.database.DbDao
import ru.bk.klim9.xingtest.repository.DataRepository
import javax.inject.Singleton

@Suppress("unused")
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideSiteSpecsRepository(api: RemoteDataService, dbDao: DbDao) =
        DataRepository(api, dbDao)

    @Singleton
    @Provides
    fun provideMoviesService() : RemoteDataService {
        return ApiFactory.MOVIES_SERVICE
    }

    @Singleton
    @Provides
    fun provideMoviesDao(): DbDao {
        return DatabaseHolder.database().xingDao()
    }
}