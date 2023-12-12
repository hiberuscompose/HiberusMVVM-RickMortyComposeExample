package com.hiberus.template.data.repository.settings

import com.hiberus.template.data.datasources.features.settings.Preferences
import com.hiberus.template.domain.repository.settings.PreferencesRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PreferencesRepositoryImpl @Inject constructor(
    private val preferences: Preferences
): PreferencesRepository {
    override fun getDeviceId(): Flow<String> = this.preferences.getDeviceId()

    override fun setDeviceId(deviceId: String): Job = this.preferences.setDeviceId(deviceId)
}
