package com.axoft.axmobilepedidos.presentation.feature.pedido.articulo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axoft.axmobilepedidos.domain.model.stock.Articulo
import com.axoft.axmobilepedidos.domain.usecase.articulo.GetArticulosUseCase
import com.axoft.axmobilepedidos.presentation.common.utils.constant.ErrorConst
import com.axoft.axmobilepedidos.presentation.common.utils.mapper.toSimpleItem
import com.axoft.axmobilepedidos.presentation.common.utils.state.UiState
import com.axoft.axmobilepedidos.presentation.model.view.ItemCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ArticuloViewModel
 *
 * ViewModel encargado de gestionar la lógica y el estado de la pantalla de selección
 * de artículos. Recupera los artículos desde el dominio usando GetArticulosUseCase,
 * transforma los datos para la capa de presentación (ItemCard), y expone el estado
 * mediante UiState (Loading, Success, Error) para ser consumido por la UI.
 *
 * @param getArticulosUseCase UseCase que obtiene la lista de artículos desde el dominio.
 */
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

            } catch (ex: Exception) {
                _articulos.value = UiState.Error(message = "${ErrorConst.ERROR_MESSAGE} $ex")
            }
        }
    }
}
