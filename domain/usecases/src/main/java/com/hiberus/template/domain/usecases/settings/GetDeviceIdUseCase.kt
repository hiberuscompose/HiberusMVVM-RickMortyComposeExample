package com.hiberus.template.domain.usecases.settings

import com.hiberus.template.domain.repository.settings.PreferencesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class GetDeviceIdUseCase @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) {
    operator fun invoke(): Flow<String> = this.preferencesRepository.getDeviceId()
}
