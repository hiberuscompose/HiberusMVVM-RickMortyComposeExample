package com.hiberus.template.core.ui.compose

import androidx.compose.runtime.compositionLocalOf
import com.hiberus.template.core.ui.authmanager.entities.BiometricCapabilities
import com.hiberus.template.core.ui.networking.NetworkStatus

val LocalNetworkStatus = compositionLocalOf<NetworkStatus> {
    NetworkStatus.Available
}

val LocalBiometricCapabilities = compositionLocalOf { BiometricCapabilities() }