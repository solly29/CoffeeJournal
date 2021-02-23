package com.example.coffeejournal.base

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.example.coffeejournal.presentation.ext.makeToast

abstract class BaseActivity<T: BaseViewModel, B: ViewDataBinding>: AppCompatActivity() {

    abstract val layoutId: Int
    abstract val viewModel: T
    lateinit var binding: B

    abstract fun initStartView()

    abstract fun initDataBinding()

    abstract fun initEvent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        initStartView()

        with(viewModel){
            toastLiveData.observe(this@BaseActivity, Observer {
                this@BaseActivity.makeToast(it)
            })
        }

        initDataBinding()
        initEvent()
    }
}