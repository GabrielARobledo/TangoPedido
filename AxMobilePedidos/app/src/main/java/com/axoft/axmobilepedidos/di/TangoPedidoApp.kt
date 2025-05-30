package com.axoft.axmobilepedidos.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * TangoPedidoApp
 *
 * Clase Application principal de la app, anotada con @HiltAndroidApp
 * para habilitar la integración de Dagger Hilt en todo el ciclo de vida
 * de la aplicación.
 * Esta clase sirve como punto de entrada para la configuración
 * de dependencias globales y permite que Hilt genere los componentes
 * necesarios para la inyección en actividades, fragments, viewmodels, etc.
 *
 * @see HiltAndroidApp
 */
@HiltAndroidApp
class TangoPedidoApp : Application()