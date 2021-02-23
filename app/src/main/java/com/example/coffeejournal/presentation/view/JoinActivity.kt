package com.example.coffeejournal.presentation.view

import android.annotation.SuppressLint
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.example.coffeejournal.R
import com.example.coffeejournal.base.BaseActivity
import com.example.coffeejournal.databinding.ActivityJoinBinding
import com.example.coffeejournal.presentation.viewmodel.JoinViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class JoinActivity : BaseActivity<JoinViewModel, ActivityJoinBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_join
    override val viewModel: JoinViewModel by viewModel()

    override fun initStartView() {
        viewModel.appBarData.title = "회원가입"

        binding.viewModel = viewModel
    }

    @SuppressLint("ResourceAsColor")
    override fun initDataBinding() {
        with(viewModel) {
            idOverlapLiveData.observe(this@JoinActivity, Observer {
                binding.joinIdOverlapText.apply {
                    if (it) {
                        text = "사용가능한 아이디 입니다."
                        setTextColor(ContextCompat.getColor(this@JoinActivity, R.color.success_color))
                    } else {
                        text = "사용불가능한 아이디 입니다."
                        setTextColor(ContextCompat.getColor(this@JoinActivity, R.color.fail_color))
                    }
                }
            })

            idLiveData.observe(this@JoinActivity, Observer {
                if(idOverlapLiveData.value == true)
                    resetIdOverlap()
            })

            pwLiveData.observe(this@JoinActivity, Observer {
                binding.joinPwRegexText.visibility = setViewVisible(pwRegexCheck())
            })

            pwCheckLiveData.observe(this@JoinActivity, Observer {
                binding.joinPwCheckText.visibility = setViewVisible(pwCheck())
            })

            emailLiveData.observe(this@JoinActivity, Observer {
                binding.joinEmailCheckText.visibility = setViewVisible(emailRegexCheck())
            })

            joinStateLiveData.observe(this@JoinActivity, Observer {
                if(it)
                    toastLiveData.value = "회원가입 성공"
                else
                    toastLiveData.value = "회원가입 실패"
            })
        }
    }

    override fun initEvent() {

    }

    private fun setViewVisible(visible: Boolean) = if(!visible) View.VISIBLE else View.INVISIBLE
}