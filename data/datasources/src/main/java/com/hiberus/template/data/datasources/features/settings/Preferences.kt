package com.hiberus.template.data.datasources.features.settings

import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow

interface Preferences {
    fun getDeviceId(): Flow<String>

    fun setDeviceId(deviceId: String): Job
}
