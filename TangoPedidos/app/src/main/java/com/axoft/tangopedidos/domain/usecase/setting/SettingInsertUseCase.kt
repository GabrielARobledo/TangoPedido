package com.axoft.tangopedidos.domain.usecase.setting

import com.axoft.tangopedidos.data.local.entities.SettingEntity
import com.axoft.tangopedidos.data.repository.app.SettingRepository
import javax.inject.Inject

class SettingInsertUseCase @Inject constructor(val settingRepository: SettingRepository)  {
    suspend operator fun invoke(settingEntity: SettingEntity) {
        settingRepository.insert(settingEntity)
    }
}
