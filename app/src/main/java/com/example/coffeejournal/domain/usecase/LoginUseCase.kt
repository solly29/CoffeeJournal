package com.example.coffeejournal.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.coffeejournal.data.repository.LoginRepository

class LoginUseCase(private val loginRepository: LoginRepository) {

    val liveData = MutableLiveData<String>()

    fun loginCheck(id: String, pw: String): Boolean{
        liveData.value = "atat"
        return false
    }
}