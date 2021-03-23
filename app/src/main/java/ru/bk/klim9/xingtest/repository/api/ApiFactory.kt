package ru.bk.klim9.xingtest.repository.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.bk.klim9.xingtest.BuildConfig

object ApiFactory {

    private val okHttpClient: OkHttpClient by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        buildClient()
    }

    val REMOTE_SERVICE: RemoteDataService by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        createService()
    }

    private fun createService(): RemoteDataService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_ENDPOINT)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RemoteDataService::class.java)
    }


    private fun buildClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor())
            .addInterceptor(interceptor)
            .build()
    }
}
