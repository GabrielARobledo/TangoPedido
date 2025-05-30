package com.axoft.axmobilepedidos.presentation.common.ui.component.card

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.axoft.axmobilepedidos.presentation.common.ui.component.progress.CircularLoadingWithText
import com.axoft.axmobilepedidos.presentation.common.utils.state.UiState
import com.axoft.axmobilepedidos.presentation.model.view.contract.SimpleCardDisplayable

/**
 * LoadItemCard
 *
 * Composable genérico que muestra una lista de entidades que implementan SimpleCardDisplayable,
 * manejando los estados de carga (Loading), éxito (Success) y error (Error).
 * Es ideal para representar listados reutilizables que consumen datos asincrónicos.
 *
 * @param state Estado actual (UiState) que contiene la lista de datos o el estado de carga/error.
 * @param imageIcon Icono opcional a mostrar en cada item de la lista.
 * @param onClick Acción a ejecutar cuando se selecciona un item.
 */
@Composable
fun <T : SimpleCardDisplayable> LoadItemCard(
    state: UiState<List<T>>,
    imageIcon: ImageVector? = null,
    onClick: (T) -> Unit
) {
    when (state) {
        is UiState.Loading -> CircularLoadingWithText(state.label)
        is UiState.Success -> SuccessStateView(state.data, imageIcon, onClick)
        is UiState.Error -> ErrorStateView(state.message)
    }
}

@Composable
private fun <T : SimpleCardDisplayable> SuccessStateView(
    data: List<T>,
    imageIcon: ImageVector?,
    onClick: (T) -> Unit
) {
    LazyColumn {
        items(data) { item ->
            InfoCard(item = item, imageIcon = imageIcon) { item ->
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
