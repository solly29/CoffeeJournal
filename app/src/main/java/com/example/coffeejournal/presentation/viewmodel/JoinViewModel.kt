package com.example.coffeejournal.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coffeejournal.base.BaseViewModel
import com.example.coffeejournal.domain.usecase.JoinUseCase

class JoinViewModel(private val joinUseCase: JoinUseCase): BaseViewModel() {

    val idLiveData = MutableLiveData<String>()
    val pwLiveData = MutableLiveData<String>()
    val pwCheckLiveData = MutableLiveData<String>()
    val emailLiveData = MutableLiveData<String>()

    private val _joinStateLiveData = MutableLiveData<Boolean>()
    val joinStateLiveData: LiveData<Boolean> get() = _joinStateLiveData

    private val _idOverlapLiveData = MutableLiveData<Boolean>()
    val idOverlapLiveData: LiveData<Boolean> get() = _idOverlapLiveData

    private val pwRegex = """^(?=.*[0-9])(?=.*[a-z])(?=.*[@#${'$'}%!\-_?${"()"}])(?=\S+${'$'}).{8,}""".toRegex()
    private val emailRegex = """^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}${'$'}""".toRegex()

    fun joinButtonClick() {
        _joinStateLiveData.value =
            if(idOverlapLiveData.value == true && pwRegexCheck() && pwCheck() && emailRegexCheck())
                joinUseCase.joinClick(idLiveData.value ?: "", pwLiveData.value ?: "", emailLiveData.value ?: "")
            else
                false
    }

    fun idOverlapClick() {
        if(!idLiveData.value.isNullOrBlank())
            _idOverlapLiveData.value = idLiveData.value?.let { joinUseCase.idOverlapCheck(it) }
        else
            toastLiveData.value = "아이디를 입력하세요."
    }

    fun pwRegexCheck() = pwLiveData.value?.let { pwRegex.matchEntire(it)?.value == it } ?: false

    fun pwCheck() =
        if(pwRegexCheck())
            pwLiveData.value == pwCheckLiveData.value
        else
            false

    fun emailRegexCheck() = emailLiveData.value?.let { emailRegex.matchEntire(it)?.value == it } ?: false

    fun resetIdOverlap() { _idOverlapLiveData.value = false }

}