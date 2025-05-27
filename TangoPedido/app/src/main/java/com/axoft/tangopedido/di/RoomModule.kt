package com.axoft.tangopedido.di

import android.content.Context
import androidx.room.Room
import com.axoft.tangopedido.data.local.dao.ConfiguracionDao
import com.axoft.tangopedido.data.local.dao.RenglonDao
import com.axoft.tangopedido.data.local.database.PedidosDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): PedidosDB =
        Room.databaseBuilder(context, PedidosDB::class.java, "PedidoDB.sqlite")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideConfiguracionDao(appDatabase: PedidosDB): ConfiguracionDao =
        appDatabase.configuracionDao()

    @Provides
    fun provideRenglonDao(appDatabase: PedidosDB): RenglonDao =
        appDatabase.renglonDao()
}
