package com.axoft.tangopedido.domain.usecase.setting

import com.axoft.tangopedido.data.repository.SettingRepository
import javax.inject.Inject

class SettingGetFirstUseCase @Inject constructor(val settingRepository: SettingRepository) {
    suspend operator fun invoke() {
        settingRepository.getSetting()
    }
}
