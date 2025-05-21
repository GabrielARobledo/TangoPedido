package com.axoft.tangopedido.data.repository

import com.axoft.tangopedido.data.remote.api.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val loginService: LoginService) {
    suspend fun doLogin(id: Int): Boolean {
        return loginService.doLogin(id)
    }
}