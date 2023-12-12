package com.hiberus.template.data.datasources.core.settings

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.hiberus.template.data.datasources.features.settings.Preferences
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class PreferencesDataStore @Inject constructor(
    private val context: Context
): Preferences {
    override fun getDeviceId(): Flow<String> = this@PreferencesDataStore.context.dataStore.data.map { pref ->
        pref[stringPreferencesKey("DeviceId")] ?: ""
    }

    override fun setDeviceId(deviceId: String) = CoroutineScope(Dispatchers.IO).launch {
        this@PreferencesDataStore.context.dataStore.edit { prefs ->
            val currentDeviceId = prefs[stringPreferencesKey("DeviceId")] ?: ""
            if (currentDeviceId.isNullOrEmpty())
                prefs[stringPreferencesKey("DeviceId")] = deviceId
        }
    }
}

private val Context.dataStore by preferencesDataStore("MVVMProjectAppPreferences")
