package com.axoft.axmobilepedidos.presentation.model.view.contract

/**
 * SimpleCardDisplayable
 *
 * Contrato (interface) que define las propiedades mínimas requeridas para que un objeto pueda ser mostrado en un componente de tipo Card
 * dentro de la interfaz.
 *
 * Cualquier clase que implemente esta interface puede ser usada en composables genéricos que rendericen tarjetas (Cards),
 * asegurando acceso a un identificador único, un código y una descripción opcional.
 */
interface SimpleCardDisplayable {
    val id: Int
    val codigo: String?
    val descripcion: String?
}
