package com.hiberus.template.presentation.viewmodels.settings

import androidx.lifecycle.ViewModel
import com.hiberus.template.domain.usecases.settings.GetDeviceIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DeviceViewModel @Inject constructor(
    private val getDeviceId: GetDeviceIdUseCase
): ViewModel() {
}