package com.example.coffeejournal.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coffeejournal.R
import com.example.coffeejournal.base.BaseActivity
import com.example.coffeejournal.viewmodel.IntroViewModel

class IntroActivity: BaseActivity<IntroViewModel>() {

    override val layoutId: Int
        get() = R.layout.activity_intro
    override val viewModel: IntroViewModel
        get() = IntroViewModel()

    override fun initStartView() {

    }

    override fun initDataBinding() {

    }

    override fun initEvent() {

    }
}