package com.axoft.tangopedido.data.repository.app

import com.axoft.tangopedido.data.local.dao.ConfiguracionDao
import com.axoft.tangopedido.data.local.entities.SettingEntity
import javax.inject.Inject

class SettingRepository @Inject constructor(val configuracionDao: ConfiguracionDao) {
    suspend fun insert(settingEntity: SettingEntity) {
        configuracionDao.insert(settingEntity)
    }

    suspend fun getSetting(): SettingEntity? {
        return configuracionDao.getUserAll()[0]
    }
}
