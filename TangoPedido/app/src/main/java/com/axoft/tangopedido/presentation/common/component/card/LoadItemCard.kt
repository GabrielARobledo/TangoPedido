package com.axoft.tangopedido.presentation.common.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.axoft.tangopedido.presentation.common.component.progress.CircularProgressCustom
import com.axoft.tangopedido.presentation.model.ItemCard
import com.axoft.tangopedido.presentation.uistate.UiState

@Composable
fun LoadItemCard(
    state: UiState<List<ItemCard>>,
    onToggleFavorite: ((ItemCard) -> Unit)? = null,
    onClick: (ItemCard) -> Unit,
) {
    when (state) {
        is UiState.Loading -> CircularProgressCustom(state.label)
        is UiState.Success -> {
            Column {
                state.data.forEach { item ->
                    key(item.codigo) {
                        ContentCard(
                            item = item,
                            onToggleFavorite = onToggleFavorite,
                            onClick = onClick
                        )
                    }
                }
            }
        }

        is UiState.Error -> Text(
            "Error: ${state.message}",
            color = MaterialTheme.colorScheme.error
        )
    }
}



