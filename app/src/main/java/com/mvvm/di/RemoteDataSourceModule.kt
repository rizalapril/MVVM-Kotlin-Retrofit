package com.mvvm.di

import android.util.Log
import com.google.gson.Gson
import com.mvvm.data.remote.api.RemoteDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import java.util.concurrent.TimeUnit

val remoteDataSourceModule = module {
    single {
        Gson()
    }

    single {
        createOkHttpClient()
    }

    single {
        RemoteDataSource(get())
    }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInceptor = HttpLoggingInterceptor()
    httpLoggingInceptor.level = HttpLoggingInterceptor.Level.BASIC

    var okHttpClient = OkHttpClient()

    try{
        okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInceptor)
            .retryOnConnectionFailure(true)
            .build()
    }catch (e: Exception){
        Log.i("ErrorNetworking", "${e.message}")
    }

    return okHttpClient
}