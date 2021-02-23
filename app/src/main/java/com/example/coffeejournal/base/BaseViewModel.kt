package com.example.coffeejournal.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coffeejournal.domain.model.AppBarData

open class BaseViewModel: ViewModel() {

    val toastLiveData = MutableLiveData<String>()

    val appBarData = AppBarData(title = "")
}