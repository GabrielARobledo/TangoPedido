package com.axoft.axmobilepedidos.domain.usecase.setting

import com.axoft.axmobilepedidos.data.repository.app.SettingRepository
import javax.inject.Inject

class SettingGetFirstUseCase @Inject constructor(val settingRepository: SettingRepository) {
    suspend operator fun invoke() {
        settingRepository.getSetting()
    }
}
