package com.hurtado.data.di

import com.hurtado.data.BuildConfig
import com.hurtado.data.remote.ItemDataSource
import com.hurtado.data.remote.ItemService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRemoteModule(baseUrl: String) = module {

    factory<Interceptor> {
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    factory {
        val client = OkHttpClient.Builder()

        client.addInterceptor { chain ->
            chain.proceed(chain.request().newBuilder()
                .addHeader("Authorization", BuildConfig.ApiKey).build())
        }

        client.addInterceptor(get())
        client.build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    factory{ get<Retrofit>().create(ItemService::class.java) }

    factory { ItemDataSource(get()) }
}