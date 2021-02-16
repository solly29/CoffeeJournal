package com.example.coffeejournal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.coffeejournal.domain.usecase.LoginUseCase
import com.example.coffeejournal.presentation.viewmodel.LoginViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class LoginUnitTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var loginUseCase: LoginUseCase

    @Test
    fun login_test() {
        /* Given */
        val loginViewModel = LoginViewModel(loginUseCase)
        loginViewModel.idLiveData.value = "d008"
        loginViewModel.pwLiveData.value = "1"

        /* when */
        `when`(loginUseCase.loginCheck(anyString(), anyString())).thenReturn(true)
        loginViewModel.loginButtonClick()

        /* then */
        verify(loginUseCase).loginCheck("d008", "1")
        assertEquals(true, loginViewModel.loginStateLiveData.value)
    }

    @Test
    fun `아이디_공백_테스트`(){
        /* Given */
        val loginViewModel = LoginViewModel(loginUseCase)
        loginViewModel.idLiveData.value = "d008"

        /* when */
        loginViewModel.loginButtonClick()

        /* then */
        verify(loginUseCase, never()).loginCheck(anyString(), anyString())
        assertEquals(null, loginViewModel.loginStateLiveData.value)
        assertEquals("아이디 또는 비밀번호가 입력되지 않았습니다.", loginViewModel.toastLiveData.value)
    }
}