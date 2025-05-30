package com.axoft.axmobilepedidos.domain.usecase.setting

import com.axoft.axmobilepedidos.data.local.entities.SettingEntity
import com.axoft.axmobilepedidos.data.repository.app.SettingRepository
import javax.inject.Inject

class SettingInsertUseCase @Inject constructor(val settingRepository: SettingRepository)  {
    suspend operator fun invoke(settingEntity: SettingEntity) {
        settingRepository.insert(settingEntity)
    }
}
