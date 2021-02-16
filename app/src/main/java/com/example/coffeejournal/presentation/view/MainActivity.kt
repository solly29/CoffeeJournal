package com.example.coffeejournal.presentation.view

import com.example.coffeejournal.R
import com.example.coffeejournal.base.BaseActivity
import com.example.coffeejournal.databinding.ActivityMainBinding
import com.example.coffeejournal.presentation.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel
        get() = MainViewModel()

    override fun initStartView() {

    }

    override fun initDataBinding() {

    }

    override fun initEvent() {

    }
}