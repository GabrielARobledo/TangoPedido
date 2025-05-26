package com.axoft.tangopedido.presentation.feature.pedido

import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity

fun Context.findActivity(): ComponentActivity =
    when (this) {
        is ComponentActivity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> throw IllegalStateException("No activity found in context")
    }
