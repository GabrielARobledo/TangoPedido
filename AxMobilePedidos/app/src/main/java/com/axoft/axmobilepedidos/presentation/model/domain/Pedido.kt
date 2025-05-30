package com.axoft.axmobilepedidos.presentation.model.domain

import com.axoft.axmobilepedidos.presentation.model.view.ItemCard
import com.axoft.axmobilepedidos.presentation.model.view.RenglonUi

/**
 * Pedido
 *
 * Modelo de dominio que representa un pedido en construcción dentro de la capa
 * de presentación. Almacena información del vendedor autenticado, el cliente
 * seleccionado, los artículos agregados al pedido (como RenglonCard)
 * y el último artículo seleccionado.
 *
 * Este objeto sirve como contenedor principal del estado del pedido
 * mientras se construye en la interfaz.
 */
data class Pedido(
    val vendedorLogged: ItemCard? = null,
    val clienteSelected: ItemCard? = null,
    val renglones: List<RenglonUi> = emptyList(),
    val articuloSelected: ItemCard? = null
)
