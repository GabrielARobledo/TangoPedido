package com.axoft.tangopedido.di

import com.axoft.tangopedido.BuildConfig
import com.axoft.tangopedido.data.remote.api.articulo.ArticuloClient
import com.axoft.tangopedido.data.remote.api.cliente.ClienteClient
import com.axoft.tangopedido.data.remote.api.vendedor.VendedorClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * RetrofitModule
 *
 * Módulo de Dagger Hilt encargado de proveer las dependencias necesarias
 * para las comunicaciones HTTP de la aplicación.
 * Configura una instancia única (singleton) de Retrofit preconfigurada
 * con el baseUrl de BuildConfig y el conversor Gson,
 * y expone los distintos clientes de API (ClienteClient, ArticuloClient, VendedorClient).
 *
 * Este módulo se instala en SingletonComponent, garantizando que
 * las dependencias sean compartidas en toda la aplicación.
 *
 * @see ClienteClient
 * @see ArticuloClient
 * @see VendedorClient
 */
@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePaisRequest(retrofit: Retrofit): ClienteClient {
        return retrofit.create(ClienteClient::class.java)
    }

    @Provides
    @Singleton
    fun provideArticuloRequest(retrofit: Retrofit): ArticuloClient {
        return retrofit.create(ArticuloClient::class.java)
    }

    @Provides
    @Singleton
    fun provideVendedorRequest(retrofit: Retrofit): VendedorClient {
        return retrofit.create(VendedorClient::class.java)
    }
}
