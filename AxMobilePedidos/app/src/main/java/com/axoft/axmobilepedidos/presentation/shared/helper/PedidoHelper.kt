package com.axoft.axmobilepedidos.presentation.shared.helper

import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity

/**
 * findActivity
 *
 * Función de extensión para Context que permite recuperar la instancia
 * de ComponentActivity asociada, navegando recursivamente a través
 * de los ContextWrapper si es necesario.
 *
 * Es útil en escenarios donde se necesita acceder a la actividad actual
 * desde un contexto genérico (por ejemplo, dentro de un Composable
 * usando LocalContext).
 *
 * @throws IllegalStateException Si no se encuentra ninguna ComponentActivity en la jerarquía.
 *
 * @return Instancia de ComponentActivity asociada al contexto actual.
 */
fun Context.findActivity(): ComponentActivity =
    when (this) {
        is ComponentActivity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> throw IllegalStateException("No activity found in context")
    }
