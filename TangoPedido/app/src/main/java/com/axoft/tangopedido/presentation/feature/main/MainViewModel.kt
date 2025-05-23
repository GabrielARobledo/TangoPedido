package com.axoft.tangopedido.presentation.feature.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axoft.tangopedido.domain.model.Articulo
import com.axoft.tangopedido.domain.model.Cliente
import com.axoft.tangopedido.domain.usecase.articulo.GetArticulosUseCase
import com.axoft.tangopedido.domain.usecase.pais.GetClientesUseCase
import com.axoft.tangopedido.presentation.mapper.toSimpleItem
import com.axoft.tangopedido.presentation.model.SimpleItemCard
import com.axoft.tangopedido.presentation.uistate.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getClientesUseCase: GetClientesUseCase,
    private val getArticuloUseCase: GetArticulosUseCase
) : ViewModel() {

    private val _clientes = MutableStateFlow<UiState<List<SimpleItemCard>>>(UiState.Loading)
    val clientes: StateFlow<UiState<List<SimpleItemCard>>> = _clientes.asStateFlow()

    private val _articulos = MutableStateFlow<UiState<List<SimpleItemCard>>>(UiState.Loading)
    val articulos: StateFlow<UiState<List<SimpleItemCard>>> = _articulos.asStateFlow()

    init {
        getDataPais()
        getDataArticulo()
    }

    fun getDataPais() {
        viewModelScope.launch {
            try {
                val result: List<Cliente>? = getClientesUseCase()
                _clientes.value = UiState.Success(result?.map { it.toSimpleItem() } ?: emptyList())

            } catch (ex: kotlin.Exception) {
                _clientes.value = UiState.Error("Ocurrió un error inesperado: $ex")
            }
        }
    }

    fun getDataArticulo() {
        viewModelScope.launch {
            try {
                val result: List<Articulo>? = getArticuloUseCase()
                _articulos.value = UiState.Success(result?.map { it.toSimpleItem() } ?: emptyList())
            } catch (ex: kotlin.Exception) {
                _articulos.value = UiState.Error("Ocurrió un error inesperado: $ex")
            }
        }
    }
}