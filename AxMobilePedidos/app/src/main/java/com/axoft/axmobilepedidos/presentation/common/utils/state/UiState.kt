package com.axoft.axmobilepedidos.presentation.common.utils.state

/**
 * UiState
 *
 * Clase sellada que representa los posibles estados de una operación asincrónica
 * en la capa de UI. Permite manejar de forma estructurada los estados de carga,
 * éxito (con datos) y error (con mensaje), facilitando el control de renderizado
 * y feedback visual en los componentes Compose.
 *
 * @param T Tipo de dato que contiene en el estado de éxito.
 */
sealed class UiState<out T> {
    data class Loading(val label: String) : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}
