package com.axoft.tangopedidos.domain.usecase.setting

import com.axoft.tangopedidos.data.repository.app.SettingRepository
import javax.inject.Inject

class SettingGetFirstUseCase @Inject constructor(val settingRepository: SettingRepository) {
    suspend operator fun invoke() {
        settingRepository.getSetting()
    }
}
