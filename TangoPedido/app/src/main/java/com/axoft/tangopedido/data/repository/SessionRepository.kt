package com.axoft.tangopedido.data.repository

import com.axoft.tangopedido.presentation.model.ItemCard
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionRepository @Inject constructor() {
    private var vendedorLoggedIn: ItemCard? = null

    fun setVendedor(vendedor: ItemCard) {
        this.vendedorLoggedIn = vendedor
    }

    fun getVendedor(): ItemCard? {
        return this.vendedorLoggedIn
    }
}
