package com.example.coffeejournal.di

import com.example.coffeejournal.presentation.viewmodel.JoinViewModel
import com.example.coffeejournal.presentation.viewmodel.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { JoinViewModel(get()) }
}