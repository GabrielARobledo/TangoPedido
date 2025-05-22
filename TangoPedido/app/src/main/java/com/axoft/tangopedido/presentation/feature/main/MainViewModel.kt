package com.axoft.tangopedido.presentation.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axoft.tangopedido.data.remote.dto.Articulo
import com.axoft.tangopedido.data.remote.dto.PaisResponse
import com.axoft.tangopedido.domain.usecase.articulo.GetArticuloListUseCase
import com.axoft.tangopedido.domain.usecase.pais.GetPaisByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPaisByIdUseCase: GetPaisByIdUseCase,
    private val getArticuloListUseCase: GetArticuloListUseCase
) : ViewModel() {

    private val _data = MutableLiveData<PaisResponse?>()
    val data: LiveData<PaisResponse?> = _data

    private val _articulos = MutableLiveData<List<Articulo>?>()
    val articulo: LiveData<List<Articulo>?> = _articulos

    init {
        getDataPais()
        getDataArticulo()
    }

    fun getDataPais() {
        viewModelScope.launch {
            try {
                val result = getPaisByIdUseCase(id = 1)
                _data.value = result
            } catch (e: Exception) {
                e.printStackTrace()
                _data.value = null
            }
        }
    }

    fun getDataArticulo() {
        viewModelScope.launch {
            try {
                val result = getArticuloListUseCase()
                _articulos.value = result
            } catch (e: Exception) {
                e.printStackTrace()
                _articulos.value = null
            }
        }
    }
}