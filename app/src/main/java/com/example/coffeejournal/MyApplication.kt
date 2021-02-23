package com.example.coffeejournal

import android.app.Application
import com.example.coffeejournal.di.repositoryModule
import com.example.coffeejournal.di.useCaseModule
import com.example.coffeejournal.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)

            modules(repositoryModule, useCaseModule, viewModelModule)
        }
    }
}