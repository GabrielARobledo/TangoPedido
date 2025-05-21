package com.axoft.tangopedido.presentation.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axoft.tangopedido.data.remote.dto.PaisResponse
import com.axoft.tangopedido.domain.usecase.PaisUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaisViewModel @Inject constructor(
    private val paisUseCase: PaisUseCase
) : ViewModel() {
    private val _data = MutableLiveData<PaisResponse?>()
    val data: LiveData<PaisResponse?> = _data

    fun getData() {
        viewModelScope.launch {
            try {
                val result = paisUseCase(
                    process = 932,
                    id = 1,
                    token = "1A65F55B-BBDB-46C3-8698-1DC9C318CD68",
                    company = 19
                )
                _data.value = result
            } catch (e: Exception) {
                e.printStackTrace()
                _data.value = null
            }
        }
    }
}