package com.example.testappmangofzco.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testappmangofzco.domain.usecases.SendPhoneUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import okhttp3.Response
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val sendPhoneUseCase: SendPhoneUseCase
) : ViewModel() {
    private val _responseOfSendPhoneLiveData = MutableLiveData<Boolean>()
    val responseOfSendPhoneLiveData: LiveData<Boolean> = _responseOfSendPhoneLiveData

    fun sendNumber(number: String) {
        viewModelScope.launch {
            val response = sendPhoneUseCase.sendNumberRepository(number)
            if(response.isSuccessful) {
                _responseOfSendPhoneLiveData.value = true
            } else if (response.code > 299) {
                _responseOfSendPhoneLiveData.value = false
            }
        }
    }
}