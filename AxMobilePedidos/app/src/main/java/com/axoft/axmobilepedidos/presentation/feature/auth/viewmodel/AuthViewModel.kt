package com.axoft.axmobilepedidos.presentation.feature.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axoft.axmobilepedidos.data.repository.app.SessionRepository
import com.axoft.axmobilepedidos.domain.usecase.vendedor.GetVendedoresUseCase
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
 * AuthViewModel
 *
 * ViewModel encargado de gestionar el flujo de autenticación de vendedores.
 * Recupera la lista de vendedores usando GetVendedoresUseCase, expone el estado
 * mediante UiState (Loading, Success, Error) y permite guardar al vendedor seleccionado
 * en la sesión a través del SessionRepository.
 *
 * Está preparado para integrarse con Hilt para inyección de dependencias.
 *
 * @param getVendedoresUseCase UseCase encargado de obtener los vendedores desde el dominio.
 * @param vendedorSessionRepository Repositorio de sesión para guardar el vendedor autenticado.
 */
@HiltViewModel
class AuthViewModel @Inject constructor(
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
            } catch (ex: Exception) {
                _vendedores.value = UiState.Error(message = "${ErrorConst.ERROR_MESSAGE} $ex")
            }
        }
    }

    fun loginVendedor(vendedor: ItemCard) {
        vendedorSessionRepository.setVendedor(vendedor)
    }
}