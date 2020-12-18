package com.example.coffeejournal.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<V: BaseViewModel>: AppCompatActivity() {

    abstract val layoutId: Int
    abstract val viewModel: V

    abstract fun initStartView()

    abstract fun initDataBinding()

    abstract fun initEvent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initStartView()
        initDataBinding()
        initEvent()
    }
}