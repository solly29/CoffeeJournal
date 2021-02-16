package com.example.coffeejournal.di

import com.example.coffeejournal.data.repository.LoginRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single { LoginRepositoryImpl() }
}