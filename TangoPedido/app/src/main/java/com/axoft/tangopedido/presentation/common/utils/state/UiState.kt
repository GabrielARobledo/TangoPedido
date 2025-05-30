package com.axoft.tangopedido.presentation.common.utils.state

sealed class UiState<out T> {
    data class Loading(val label: String) : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}
