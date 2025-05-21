package com.axoft.tangopedido.di

import com.axoft.tangopedido.data.remote.api.LoginClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val URL_API: String = "https://run.mocky.io/"

@Module
@InstallIn(SingletonComponent::class)
class RetrofitClient {

    @Provides
    @Singleton
    fun providerRetroFit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providerLoginClient(retrofit: Retrofit): LoginClient {
        return retrofit.create(LoginClient::class.java);
    }
}
