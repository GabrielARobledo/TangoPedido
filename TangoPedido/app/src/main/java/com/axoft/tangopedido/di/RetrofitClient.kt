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

@Module
@InstallIn(SingletonComponent::class)
class RetrofitClient {
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
