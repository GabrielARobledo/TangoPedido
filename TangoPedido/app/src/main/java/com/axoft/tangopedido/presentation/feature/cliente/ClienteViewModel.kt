package com.axoft.tangopedido.presentation.feature.cliente

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axoft.tangopedido.data.repository.SessionRepository
import com.axoft.tangopedido.domain.model.Cliente
import com.axoft.tangopedido.domain.model.Vendedor
import com.axoft.tangopedido.domain.usecase.cliente.GetClientesUseCase
import com.axoft.tangopedido.domain.usecase.vendedor.GetVendedoresUseCase
import com.axoft.tangopedido.presentation.common.component.card.ContentCard
import com.axoft.tangopedido.presentation.common.component.progress.CircularProgressCustom
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
import kotlin.collections.map

@HiltViewModel
class ClienteViewModel @Inject constructor(
    private val getClientesUseCase: GetClientesUseCase
) :
    ViewModel() {

    private val _clientes =
        MutableStateFlow<UiState<List<ItemCard>>>(UiState.Loading("Clientes"))
    val clientes: StateFlow<UiState<List<ItemCard>>> = _clientes.asStateFlow()

    init {
        setDataCliente()
    }

    fun setDataCliente() {
        viewModelScope.launch {
            try {
                val result: List<Cliente>? = getClientesUseCase()
                _clientes.value = UiState.Success(result?.map { it.toSimpleItem() } ?: emptyList())

            } catch (ex: kotlin.Exception) {
                _clientes.value = UiState.Error(message = "$ERROR_MESSAGE $ex")
            }
        }
    }
}