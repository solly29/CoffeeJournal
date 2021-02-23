package com.example.coffeejournal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.coffeejournal.domain.usecase.JoinUseCase
import com.example.coffeejournal.presentation.viewmodel.JoinViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class JoinUnitTest {

    // LiveData Unit Test Rule
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var joinUseCase: JoinUseCase

    lateinit var joinViewModel: JoinViewModel

    @Before
    fun setJoinViewModel() {
        joinViewModel = JoinViewModel(joinUseCase)
    }

    @Test
    fun join_success_test() {
        /* Given */
        joinViewModel.idLiveData.value = "test"
        joinViewModel.pwLiveData.value = "test123!!"
        joinViewModel.pwCheckLiveData.value = "test123!!"
        joinViewModel.emailLiveData.value = "test1@naver.com"

        /* When */
        `when`(joinUseCase.joinClick(anyString(), anyString(), anyString())).thenReturn(true)
        `when`(joinUseCase.idOverlapCheck(anyString())).thenReturn(true)
        joinViewModel.idOverlapClick()
        joinViewModel.joinButtonClick()

        /* Then */
        verify(joinUseCase).joinClick("test", "test123!!", "test1@naver.com")
        assertEquals(true, joinViewModel.joinStateLiveData.value)
    }

    @Test
    fun join_id_overlap_test() {
        joinViewModel.idLiveData.value = "admin"

        `when`(joinUseCase.idOverlapCheck(anyString())).thenReturn(true)
        joinViewModel.idOverlapClick()

        verify(joinUseCase).idOverlapCheck("admin")
        assertEquals(true, joinViewModel.idOverlapLiveData.value)
    }

    @Test
    fun join_id_overlap_blank_test() {
        joinViewModel.idLiveData.value = null

        joinViewModel.idOverlapClick()

        verify(joinUseCase, never()).idOverlapCheck(anyString())
        assertEquals(null, joinViewModel.idOverlapLiveData.value)
        assertEquals("아이디를 입력하세요.", joinViewModel.toastLiveData.value)
    }

    @Test
    fun password_regex_test() {
        joinViewModel.pwLiveData.value = "test123123123!"

        val test = joinViewModel.pwRegexCheck()

        assertEquals(true, test)
    }

    @Test
    fun `비밀번호_확인_테스트`() {
        joinViewModel.pwLiveData.value = "test123123123!"
        joinViewModel.pwCheckLiveData.value = "test123123123!"

        val test = joinViewModel.pwCheck()

        assertEquals(true, test)
    }

    @Test
    fun `이메일_유효성_검사`() {
        joinViewModel.emailLiveData.value = "test1@naver.com"

        val test = joinViewModel.emailRegexCheck()

        assertEquals(true, test)
    }
}