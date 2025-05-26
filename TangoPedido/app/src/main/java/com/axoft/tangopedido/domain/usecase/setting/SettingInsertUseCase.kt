package com.axoft.tangopedido.domain.usecase.setting

import com.axoft.tangopedido.data.local.entities.SettingEntity
import com.axoft.tangopedido.data.repository.SettingRepository
import javax.inject.Inject

class SettingInsertUseCase @Inject constructor(val settingRepository: SettingRepository)  {
    suspend operator fun invoke(settingEntity: SettingEntity) {
        settingRepository.insert(settingEntity)
    }
}
