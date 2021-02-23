package com.example.coffeejournal.data.entity

data class BaseData<T>(
    val resultCode: Int,
    val resultData: List<T>,
    val resultMessage: String
)