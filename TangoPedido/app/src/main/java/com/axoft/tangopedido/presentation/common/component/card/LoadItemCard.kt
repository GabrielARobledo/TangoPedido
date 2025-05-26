package com.axoft.tangopedido.presentation.common.component.card

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.axoft.tangopedido.presentation.common.component.progress.CircularProgressCustom
import com.axoft.tangopedido.presentation.model.ItemCard
import com.axoft.tangopedido.presentation.uistate.UiState

@Composable
fun LoadItemCard(
    state: UiState<List<ItemCard>>,
    onClick: (ItemCard) -> Unit
) {
    when (state) {
        is UiState.Loading -> CircularProgressCustom(state.label)
        is UiState.Success -> {
            Column {
                state.data.forEach { item ->
                    ContentCard(item = item) { itemSelected ->
                        onClick(itemSelected)
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
