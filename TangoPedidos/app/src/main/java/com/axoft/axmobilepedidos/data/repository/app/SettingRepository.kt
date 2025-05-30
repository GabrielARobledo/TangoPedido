package com.axoft.tangopedidos.data.repository.app

import com.axoft.tangopedidos.data.local.dao.ConfiguracionDao
import com.axoft.tangopedidos.data.local.entities.SettingEntity
import javax.inject.Inject

class SettingRepository @Inject constructor(val configuracionDao: ConfiguracionDao) {
    suspend fun insert(settingEntity: SettingEntity) {
        configuracionDao.insert(settingEntity)
    }

    suspend fun getSetting(): SettingEntity? {
        return configuracionDao.getUserAll()[0]
    }
}
