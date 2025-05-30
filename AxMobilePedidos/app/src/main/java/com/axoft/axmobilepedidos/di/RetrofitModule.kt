package com.axoft.axmobilepedidos.di

import com.axoft.axmobilepedidos.BuildConfig
import com.axoft.axmobilepedidos.data.remote.api.articulo.ArticuloClient
import com.axoft.axmobilepedidos.data.remote.api.cliente.ClienteClient
import com.axoft.axmobilepedidos.data.remote.api.pedido.PedidoClient
import com.axoft.axmobilepedidos.data.remote.api.vendedor.VendedorClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
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
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val requestWithHeaders = originalRequest.newBuilder()
                .header("ApiAuthorization", BuildConfig.API_TOKEN)
                .header("Company", BuildConfig.API_COMPANY.toString())
                .build()
            chain.proceed(requestWithHeaders)
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(headerInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
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
    fun providePedidoRequest(retrofit: Retrofit): PedidoClient {
        return retrofit.create(PedidoClient::class.java)
    }

    @Provides
    @Singleton
    fun provideVendedorRequest(retrofit: Retrofit): VendedorClient {
        return retrofit.create(VendedorClient::class.java)
    }
}
