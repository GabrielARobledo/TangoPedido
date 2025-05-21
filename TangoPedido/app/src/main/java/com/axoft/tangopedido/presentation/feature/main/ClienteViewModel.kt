package com.axoft.tangopedido.presentation.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axoft.tangopedido.data.remote.dto.GetByIdResponseDto
import com.axoft.tangopedido.domain.usecase.GetByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClienteViewModel @Inject constructor(
    private val getByIdUseCase: GetByIdUseCase
) : ViewModel() {
    private val _data = MutableLiveData<GetByIdResponseDto?>()
    val data: LiveData<GetByIdResponseDto?> = _data

    fun fetchData() {
        viewModelScope.launch {
            try {
                val result = getByIdUseCase(
                    process = 2117,
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