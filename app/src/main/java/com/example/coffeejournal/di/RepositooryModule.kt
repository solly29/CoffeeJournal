package com.example.coffeejournal.di

import com.example.coffeejournal.data.repository.LoginRepository
import com.example.coffeejournal.data.repository.LoginRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<LoginRepository> { LoginRepositoryImpl() }
}