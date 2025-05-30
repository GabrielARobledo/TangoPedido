package com.axoft.axmobilepedidos.presentation.model.view

import com.axoft.axmobilepedidos.presentation.model.view.contract.SimpleCardDisplayable

/**
 * ItemCard
 *
 * Modelo de presentación que representa un ítem simple (como vendedor, cliente, artículo) que puede ser mostrado
 * en un componente de tipo Card.
 * Implementa SimpleCardDisplayable para asegurar compatibilidad con composables genéricos que rendericen tarjetas.
 *
 * @property id Identificador único del ítem.
 * @property codigo Código representativo del ítem (opcional).
 * @property descripcion Descripción breve del ítem (opcional).
 *
 * @function getCodeDescription Retorna una cadena combinada
 * de código y descripción, útil para mostrar como texto principal.
 */
data class ItemCard(
    override val id: Int,
    override val codigo: String?,
    override val descripcion: String?
) : SimpleCardDisplayable {
    fun getCodeDescription(): String {
        return "$codigo - $descripcion"
    }
}
