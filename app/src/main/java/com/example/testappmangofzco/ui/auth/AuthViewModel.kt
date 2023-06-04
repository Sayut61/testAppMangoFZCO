package com.example.testappmangofzco.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testappmangofzco.domain.usecases.SendPhoneUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val sendPhoneUseCase: SendPhoneUseCase
) : ViewModel() {
    fun sendNumber(number: String) {
        viewModelScope.launch {
            sendPhoneUseCase.sendNumberRepository(number)
        }
    }
}