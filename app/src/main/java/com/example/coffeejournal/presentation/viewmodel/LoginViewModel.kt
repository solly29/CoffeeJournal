package com.example.coffeejournal.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coffeejournal.base.BaseViewModel
import com.example.coffeejournal.domain.usecase.LoginUseCase

class LoginViewModel(private val loginUseCase: LoginUseCase): BaseViewModel() {

    val idLiveData = MutableLiveData<String>()
    val pwLiveData = MutableLiveData<String>()

    private val _loginStateLiveData = MutableLiveData<Boolean>()
    val loginStateLiveData: LiveData<Boolean> get() = _loginStateLiveData

    private val _toastLiveData = MutableLiveData<String>()
    val toastLiveData: LiveData<String> get() = _toastLiveData

    fun loginButtonClick(){
        if(!idLiveData.value.isNullOrBlank() && !pwLiveData.value.isNullOrBlank())
            _loginStateLiveData.value = loginUseCase.loginCheck(idLiveData.value ?: "", pwLiveData.value ?: "")
        else
            _toastLiveData.value = "아이디 또는 비밀번호가 입력되지 않았습니다."
    }
}