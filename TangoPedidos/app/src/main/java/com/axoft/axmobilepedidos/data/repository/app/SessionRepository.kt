package com.axoft.tangopedidos.data.repository.app

import com.axoft.tangopedidos.presentation.model.view.ItemCard
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
