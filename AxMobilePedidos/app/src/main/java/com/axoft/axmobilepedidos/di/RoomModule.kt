package com.axoft.axmobilepedidos.di

import android.content.Context
import androidx.room.Room
import com.axoft.axmobilepedidos.data.local.dao.ConfiguracionDao
import com.axoft.axmobilepedidos.data.local.database.LoginDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * RoomModule
 *
 * Módulo de Dagger Hilt encargado de proveer las dependencias necesarias
 * para la base de datos local usando Room.
 * Configura la instancia única (singleton) de LoginDataBase y expone
 * su DAO (ConfiguracionDao) para que pueda ser inyectado en los repositorios
 * o casos de uso.
 *
 * Usa el contexto de aplicación (@ApplicationContext) para construir
 * la base de datos, asegurando la persistencia local en el dispositivo.
 *
 * @see LoginDataBase
 * @see ConfiguracionDao
 */
@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): LoginDataBase =
        Room.databaseBuilder(context, LoginDataBase::class.java, "PedidoDB.sqlite")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideConfiguracionDao(appDatabase: LoginDataBase): ConfiguracionDao =
        appDatabase.configuracionDao()
}
