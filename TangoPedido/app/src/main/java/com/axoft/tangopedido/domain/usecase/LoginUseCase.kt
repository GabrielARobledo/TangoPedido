package com.axoft.tangopedido.domain.usecase

import com.axoft.tangopedido.data.repository.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    suspend operator fun invoke(id: Int): Boolean {
        return loginRepository.doLogin(id)
    }
}
