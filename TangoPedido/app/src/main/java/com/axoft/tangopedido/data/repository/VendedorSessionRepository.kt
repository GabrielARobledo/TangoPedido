package com.axoft.tangopedido.data.repository

import com.axoft.tangopedido.domain.model.Vendedor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VendedorSessionRepository @Inject constructor() {

    private var vendedorLoggedIn: Vendedor? = null

    fun setVendedor(vendedor: Vendedor) {
        this.vendedorLoggedIn = vendedor
    }

    fun getVendedor(): Vendedor? {
        return this.vendedorLoggedIn
    }
}