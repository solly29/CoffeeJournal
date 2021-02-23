package com.example.coffeejournal.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.coffeejournal.data.repository.LoginRepository

class LoginUseCase(private val loginRepository: LoginRepository) {

    fun loginCheck(id: String, pw: String): Boolean{
        return id == "admin" && pw == "1"
    }
}



