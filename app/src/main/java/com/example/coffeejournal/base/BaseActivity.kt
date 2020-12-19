package com.example.coffeejournal.base

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<T: BaseViewModel>: AppCompatActivity() {

    abstract val layoutId: Int
    abstract val viewModel: T

    abstract fun initStartView()

    abstract fun initDataBinding()

    abstract fun initEvent()

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initStartView()
        initDataBinding()
        initEvent()
    }
}