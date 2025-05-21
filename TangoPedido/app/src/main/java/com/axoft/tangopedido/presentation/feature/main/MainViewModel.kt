package com.axoft.tangopedido.presentation.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axoft.tangopedido.data.remote.dto.PaisResponse
import com.axoft.tangopedido.domain.usecase.PaisUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val paisUseCase: PaisUseCase) : ViewModel() {
    private val _isLogged = MutableStateFlow(false)
    val isLogged: StateFlow<Boolean> = _isLogged

    private val _data = MutableLiveData<PaisResponse?>()
    val data: LiveData<PaisResponse?> = _data

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            try {
                val result = paisUseCase(
                    process = 932,
                    id = 1,
                    token = "C8DBAA66-6845-4B4F-94AC-69AFAA36A88D",
                    company = 12
                )
                _data.value = result
            } catch (e: Exception) {
                e.printStackTrace()
                _data.value = null
            }
        }
    }

    fun loginIn() {
        viewModelScope.launch {
            _isLogged.value = true
        }
    }
}