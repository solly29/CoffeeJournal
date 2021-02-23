package com.example.coffeejournal.presentation.view

import android.content.Intent
import androidx.lifecycle.Observer
import com.example.coffeejournal.R
import com.example.coffeejournal.base.BaseActivity
import com.example.coffeejournal.databinding.ActivityIntroBinding
import com.example.coffeejournal.presentation.viewmodel.IntroViewModel

class IntroActivity : BaseActivity<IntroViewModel, ActivityIntroBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_intro
    override val viewModel: IntroViewModel = IntroViewModel()

    override fun initStartView() {
        viewModel.setLoading(false)
        binding.introProgress.showProgress()
    }

    override fun initDataBinding() {
        with(viewModel) {
            isLoadingLiveData.observe(this@IntroActivity, Observer {
                if(it) {
                    startActivity(
                        Intent(this@IntroActivity, LoginActivity::class.java)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    )
                }
            })
        }
    }

    override fun initEvent() {
        binding.introProgress.onStopListener {
            viewModel.setLoading(it)
        }
    }
}