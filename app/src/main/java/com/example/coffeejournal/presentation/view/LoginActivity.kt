package com.example.coffeejournal.presentation.view

import com.example.coffeejournal.R
import com.example.coffeejournal.base.BaseActivity
import com.example.coffeejournal.databinding.ActivityLoginBinding
import com.example.coffeejournal.presentation.viewmodel.LoginViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity: BaseActivity<LoginViewModel, ActivityLoginBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_login
    override val viewModel: LoginViewModel by viewModel()

    override fun initStartView() {
        binding.viewModel = viewModel
    }

    override fun initDataBinding() {

    }

    override fun initEvent() {

    }
}