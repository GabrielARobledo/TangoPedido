package com.axoft.axmobilepedidos.data.remote.api.pedido

import com.axoft.axmobilepedidos.data.remote.dto.PedidoResponse
import retrofit2.Response
import javax.inject.Inject


class PedidoService @Inject constructor(private val pedidoClient: PedidoClient) {
    @Throws(RuntimeException::class)
    suspend fun getAll(): PedidoResponse? {
        val response: Response<PedidoResponse> = pedidoClient.getAll()

        return if (response.isSuccessful) {
            val body = response.body()
            println("Response body: $body")

            body

        } else {
            val errorBody = response.errorBody()?.string()
            throw java.lang.RuntimeException(errorBody)
        }
    }
}
