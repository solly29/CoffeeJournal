package com.example.coffeejournal.base

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T: BaseViewModel, B: ViewDataBinding>: AppCompatActivity() {

    abstract val layoutId: Int
    abstract val viewModel: T
    lateinit var binding: B

    abstract fun initStartView()

    abstract fun initDataBinding()

    abstract fun initEvent()

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        initStartView()
        initDataBinding()
        initEvent()
    }
}