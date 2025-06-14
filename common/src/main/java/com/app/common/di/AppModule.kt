package com.app.common.di

import com.app.data.repository.MyRepositoryImpl
import com.domain.repository.MyRepository
import org.koin.dsl.module

val appModule = module {
    single<MyRepository> { MyRepositoryImpl(get()) }
}