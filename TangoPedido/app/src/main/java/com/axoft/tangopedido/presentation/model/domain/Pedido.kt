package com.axoft.tangopedido.presentation.model.domain

import com.axoft.tangopedido.presentation.model.view.ItemCard
import com.axoft.tangopedido.presentation.model.view.RenglonCard

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
    val articulos: List<RenglonCard> = emptyList(),
    val articuloSelected: ItemCard? = null
)