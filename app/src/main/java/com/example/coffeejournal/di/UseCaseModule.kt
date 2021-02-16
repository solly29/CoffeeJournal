package com.example.coffeejournal.di

import com.example.coffeejournal.domain.usecase.LoginUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { LoginUseCase(get()) }
}