package com.axoft.tangopedido.di

import com.axoft.tangopedido.data.remote.api.ClienteRequest
import com.axoft.tangopedido.data.remote.api.LoginClient
import com.axoft.tangopedido.data.remote.api.PaisClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

private const val URL_API: String = "https://run.mocky.io/"

@Module
@InstallIn(SingletonComponent::class)
class RetrofitClient {

    @Provides
    @Singleton
    @Named("LoginApi")
    fun providerRetroFit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providerLoginClient(@Named("LoginApi") retrofit: Retrofit): LoginClient {
        return retrofit.create(LoginClient::class.java);
    }
}

@Module
@InstallIn(SingletonComponent::class)
object ClienteModule {

    @Provides
    @Singleton
    @Named("ClienteApi")
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:17001//")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideClienteRequest(@Named("ClienteApi") retrofit: Retrofit): ClienteRequest {
        return retrofit.create(ClienteRequest::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object PaisModule {

    @Provides
    @Singleton
    @Named("PaisApi")
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:17001//")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePaisRequest(@Named("PaisApi") retrofit: Retrofit): PaisClient {
        return retrofit.create(PaisClient::class.java)
    }
}

