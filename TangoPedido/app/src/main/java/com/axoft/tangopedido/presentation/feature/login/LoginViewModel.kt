package com.axoft.tangopedido.presentation.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axoft.tangopedido.data.repository.app.SessionRepository
import com.axoft.tangopedido.domain.usecase.vendedor.GetVendedoresUseCase
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
class LoginViewModel @Inject constructor(
    private val getVendedoresUseCase: GetVendedoresUseCase,
    private val vendedorSessionRepository: SessionRepository
) :
    ViewModel() {

    private val _vendedores =
        MutableStateFlow<UiState<List<ItemCard>>>(UiState.Loading("Vendedores"))
    val vendedores: StateFlow<UiState<List<ItemCard>>> = _vendedores.asStateFlow()

    init {
        setDataVendedor()
    }

    private fun setDataVendedor() {
        viewModelScope.launch {
            try {
                val result = getVendedoresUseCase.invoke() ?: emptyList()
                _vendedores.value = UiState.Success(result.map { it.toSimpleItem() })
            } catch (ex: kotlin.Exception) {
                _vendedores.value = UiState.Error(message = "$ERROR_MESSAGE $ex")
            }
        }
    }

    fun loginVendedor(vendedor: ItemCard) {
        vendedorSessionRepository.setVendedor(vendedor)
    }
}
