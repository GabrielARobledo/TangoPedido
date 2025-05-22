package com.axoft.tangopedido.presentation.feature.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.axoft.tangopedido.R
import com.axoft.tangopedido.presentation.common.component.button.PrimaryButton
import com.axoft.tangopedido.presentation.common.component.textfield.CustomTextField
import com.axoft.tangopedido.presentation.feature.main.MainViewModel

@Composable
fun LoginScreen(
    mainViewModel: MainViewModel = hiltViewModel()
) {
    var texto1 by remember { mutableStateOf("") }
    var texto2 by remember { mutableStateOf("") }

    // UI
    Column(modifier = Modifier.padding(16.dp)) {
        CustomTextField(label = stringResource(R.string.login_key), value = texto1) {
        }

        Spacer(modifier = Modifier.height(16.dp))

        CustomTextField(label = stringResource(R.string.login_pass), value = texto2) {
        }
    }
}