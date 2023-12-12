package com.hiberus.template.domain.repository.settings

import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow

interface PreferencesRepository {
    fun getDeviceId(): Flow<String>

    fun setDeviceId(deviceId: String): Job
}
