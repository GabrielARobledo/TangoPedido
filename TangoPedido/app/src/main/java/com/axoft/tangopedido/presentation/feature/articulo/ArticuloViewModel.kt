package com.axoft.tangopedido.presentation.feature.articulo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axoft.tangopedido.domain.model.stock.Articulo
import com.axoft.tangopedido.domain.usecase.articulo.GetArticulosUseCase
import com.axoft.tangopedido.presentation.common.utils.constant.ErrorConst.ERROR_MESSAGE
import com.axoft.tangopedido.presentation.common.utils.mapper.toSimpleItem
import com.axoft.tangopedido.presentation.model.view.ItemCard
import com.axoft.tangopedido.presentation.common.utils.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticuloViewModel @Inject constructor(
    private val getArticulosUseCase: GetArticulosUseCase
) :
    ViewModel() {

    private val _articulos =
        MutableStateFlow<UiState<List<ItemCard>>>(UiState.Loading("Articulos"))
    val articulos: StateFlow<UiState<List<ItemCard>>> = _articulos.asStateFlow()

    init {
        setDataArticulo()
    }

    fun setDataArticulo() {
        viewModelScope.launch {
            try {
                val result: List<Articulo>? = getArticulosUseCase()
                _articulos.value = UiState.Success(result?.map { it.toSimpleItem() } ?: emptyList())

            } catch (ex: kotlin.Exception) {
                _articulos.value = UiState.Error(message = "$ERROR_MESSAGE $ex")
            }
        }
    }
}