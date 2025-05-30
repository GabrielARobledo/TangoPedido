package com.axoft.axmobilepedidos.presentation.model.view

/**
 * RenglonCard
 *
 * Modelo de presentación que representa un renglón (línea) dentro de un pedido,
 * incluyendo detalles como código, descripción, cantidad pedida, precio unitario e importe total calculado.
 *
 * Este objeto es usado principalmente para renderizar componentes visuales
 * como RenglonCard en la UI, permitiendo mostrar y manipular los datos de cada ítem agregado al pedido.
 *
 * @property id Identificador único del renglón.
 * @property codigo Código del artículo.
 * @property descripcion Descripción del artículo.
 * @property cantidadPedida Cantidad solicitada para este renglón.
 * @property precio Precio unitario del artículo.
 * @property importe Importe total (precio * cantidad).
 */
data class RenglonUi(
    val id: Int,
    val codigo: String,
    val descripcion: String,
    val cantidadPedida: Float,
    val precio: Float,
    val importe: Float
)
