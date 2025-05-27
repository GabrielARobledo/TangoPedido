package com.axoft.tangopedido.presentation.feature.articulo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axoft.tangopedido.domain.model.Articulo
import com.axoft.tangopedido.domain.usecase.articulo.GetArticulosUseCase
import com.axoft.tangopedido.presentation.constant.ErrorConst.ERROR_MESSAGE
import com.axoft.tangopedido.presentation.mapper.toSimpleItem
import com.axoft.tangopedido.presentation.model.ItemCard
import com.axoft.tangopedido.presentation.uistate.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticuloViewModel @Inject constructor(
    private val getArticulosUseCase: GetArticulosUseCase
) : ViewModel() {

    private val _articulos =
        MutableStateFlow<UiState<List<ItemCard>>>(UiState.Loading("Articulos"))
    val articulos: StateFlow<UiState<List<ItemCard>>> = _articulos.asStateFlow()

    private val favoritos = mutableSetOf<String>()
    private var originalList: List<ItemCard> = emptyList()

    init {
        setDataArticulo()
    }

    fun setDataArticulo() {
        viewModelScope.launch {
            try {
                val result: List<Articulo>? = getArticulosUseCase()
                val mapped = result?.map {
                    it.toSimpleItem(isFavorite = favoritos.contains(it.codigo))
                } ?: emptyList()

                originalList = mapped

                _articulos.value = UiState.Success(
                    reorderListWithFavorites(mapped)
                )
            } catch (ex: Exception) {
                _articulos.value = UiState.Error(message = "$ERROR_MESSAGE $ex")
            }
        }
    }

    fun toggleFavorito(item: ItemCard) {
        val codigo = item.codigo ?: return

        if (favoritos.contains(codigo)) {
            favoritos.remove(codigo)
        } else {
            favoritos.add(codigo)
        }

        val updated = originalList.map {
            it.copy(isFavorite = favoritos.contains(it.codigo))
        }

        _articulos.value = UiState.Success(
            reorderListWithFavorites(updated)
        )
    }

    private fun reorderListWithFavorites(list: List<ItemCard>): List<ItemCard> {
        return list.sortedWith(
            compareByDescending<ItemCard> { it.isFavorite }
                .thenBy { originalList.indexOfFirst { original -> original.codigo == it.codigo } }
        )
    }
}
