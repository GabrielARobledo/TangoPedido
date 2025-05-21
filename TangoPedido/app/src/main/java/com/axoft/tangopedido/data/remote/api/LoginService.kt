package com.axoft.tangopedido.data.remote.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: LoginClient) {
    suspend fun doLogin(id: Int): Boolean {
        return withContext(Dispatchers.IO) {
            val response = loginClient.doLogin()
            response.isSuccessful && response.body()?.id == id
        }
    }
}