package com.axoft.axmobilepedidos.presentation.feature.app.viewmodel

import androidx.lifecycle.ViewModel
import com.axoft.axmobilepedidos.BuildConfig
import com.axoft.axmobilepedidos.data.repository.app.SessionRepository
import com.axoft.axmobilepedidos.presentation.feature.app.navigation.AppNavigation
import com.axoft.axmobilepedidos.presentation.model.view.ItemCard
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * AppViewModel
 *
 * ViewModel principal de la aplicación, encargado de gestionar el estado global
 * de autenticación. Consulta y manipula la sesión actual (vendedor) usando
 * SessionRepository, y determina la ruta inicial de la aplicación.
 *
 * @param sessionRepository Repositorio de sesión que almacena la información del vendedor autenticado.
 */
@HiltViewModel
class AppViewModel @Inject constructor(
    private val sessionRepository: SessionRepository
) :
    ViewModel() {

    fun authenticateDebug() {
        sessionRepository.setVendedor(ItemCard(1, "1", "WALTER AREVALO"))
    }

    fun isAuthenticated(): Boolean {
        // Sirve solo para el debug para agilizar el login.
        if (BuildConfig.LOGIN_REQUIRED){
            return sessionRepository.getVendedor() != null
        }

        authenticateDebug()
        return true;
    }

    fun getStartRoute(): String {
        return if (isAuthenticated()) AppNavigation.Pedido.route else AppNavigation.Login.route
    }
}
