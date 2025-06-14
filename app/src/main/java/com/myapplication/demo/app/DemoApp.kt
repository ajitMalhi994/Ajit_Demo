package com.myapplication.demo.app

import android.app.Application
import com.app.common.di.appModule
import com.app.common.di.networkModule
import com.app.presentation.di.viewModelModule
import com.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DemoApp : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DemoApp)
            modules(appModule, networkModule, viewModelModule, domainModule)
        }
    }
}