package com.axoft.tangopedido.presentation.common.ui.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.axoft.tangopedido.presentation.common.ui.component.progress.CircularProgressCustom
import com.axoft.tangopedido.presentation.common.utils.state.UiState
import com.axoft.tangopedido.presentation.model.view.contract.SimpleCardDisplayable

/**
 * Composable genérico para listar entidades que implementan SimpleCardDisplayable
 * mostrando estados de Loading, Success y Error.
 */
@Composable
fun <T : SimpleCardDisplayable> LoadItemCard(
    state: UiState<List<T>>,
    onClick: (T) -> Unit
) {
    when (state) {
        is UiState.Loading -> CircularProgressCustom(state.label)
        is UiState.Success -> SuccessResult(state.data, onClick)
        is UiState.Error -> ErrorStateView(state.message)
    }
}

@Composable
private fun <T : SimpleCardDisplayable> SuccessResult(data: List<T>, onClick: (T) -> Unit) {
    Column {
        data.forEach { item ->
            InfoCard(item = item) { item ->
                onClick(item)
            }
        }
    }
}

@Composable
private fun ErrorStateView(message: String) {
    Text(
        "Error: $message",
        color = MaterialTheme.colorScheme.error
    )
}
