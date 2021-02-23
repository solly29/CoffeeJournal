package com.example.coffeejournal.domain.usecase

import com.example.coffeejournal.data.repository.LoginRepository

class JoinUseCase(private val loginRepository: LoginRepository) {

    fun joinClick(id: String, pw: String, email: String) = true

    fun idOverlapCheck(id: String) = id != "admin"
}