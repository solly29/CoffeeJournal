package com.example.coffeejournal.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coffeejournal.R
import com.example.coffeejournal.base.BaseActivity
import com.example.coffeejournal.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel>() {

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