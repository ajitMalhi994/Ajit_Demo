package com.app.common.di

import com.app.data.api.HoldingsApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://35dee773a9ec441e9f38d5fc249406ce.api.mockbin.io")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HoldingsApiService::class.java)
    }
}

val intercepter = HttpLoggingInterceptor().apply {
    this.level = HttpLoggingInterceptor.Level.BODY
}

val client = OkHttpClient.Builder().apply {
    this.addInterceptor(intercepter)
}.build()