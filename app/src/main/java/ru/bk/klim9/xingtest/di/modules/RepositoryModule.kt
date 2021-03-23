package ru.bk.klim9.xingtest.di.modules

import dagger.Module
import dagger.Provides
import ru.bk.klim9.xingtest.repository.DataRepository
import ru.bk.klim9.xingtest.repository.api.ApiFactory
import ru.bk.klim9.xingtest.repository.api.RemoteDataService
import ru.bk.klim9.xingtest.repository.database.DatabaseHolder
import ru.bk.klim9.xingtest.repository.database.DbDao
import javax.inject.Singleton

@Suppress("unused")
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideDataRepository(api: RemoteDataService, dbDao: DbDao) =
        DataRepository(api, dbDao)

    @Singleton
    @Provides
    fun provideRemoteService() : RemoteDataService {
        return ApiFactory.REMOTE_SERVICE
    }

    @Singleton
    @Provides
    fun provideDbDao(): DbDao {
        return DatabaseHolder.database().dbDao()
    }
}