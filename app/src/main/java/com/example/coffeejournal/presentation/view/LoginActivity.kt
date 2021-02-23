package com.example.coffeejournal.presentation.view

import android.content.Intent
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.Observer
import com.example.coffeejournal.R
import com.example.coffeejournal.base.BaseActivity
import com.example.coffeejournal.databinding.ActivityLoginBinding
import com.example.coffeejournal.presentation.viewmodel.LoginViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>() {
    override val layoutId = R.layout.activity_login
    override val viewModel: LoginViewModel by viewModel()

    override fun initStartView() {
        viewModel.appBarData.title = "로그인"

        binding.viewModel = viewModel
    }

    override fun initDataBinding() {
        with(viewModel) {
            loginStateLiveData.observe(this@LoginActivity, Observer {
                if (it)
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                else
                    toastLiveData.value = "아이디 또는 비밀번호가 틀렸습니다."
            })
        }
    }

    override fun initEvent() {
        with(binding) {
            loginJoinButton.setOnClickListener {
                startActivity(Intent(this@LoginActivity, JoinActivity::class.java))
            }

            loginPwEditText.setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE -> {
                        this@LoginActivity.viewModel.loginButtonClick()
                        true
                    }
                    else -> false
                }
            }
        }
    }
}