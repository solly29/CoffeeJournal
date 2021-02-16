package com.example.coffeejournal.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coffeejournal.base.BaseViewModel

class IntroViewModel: BaseViewModel() {

    private val _isLoadingLiveData = MutableLiveData<Boolean>()
    val isLoadingLiveData: LiveData<Boolean> get() = _isLoadingLiveData

    fun setLoading(loading: Boolean){
        _isLoadingLiveData.value = loading
    }
}