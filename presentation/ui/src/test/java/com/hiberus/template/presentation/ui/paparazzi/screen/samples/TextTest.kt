package com.hiberus.template.presentation.ui.paparazzi.screen.samples

import androidx.compose.runtime.Composable
import com.hiberus.template.core.common.entities.enums.Component
import com.hiberus.template.presentation.ui.BasePaparazziTest

class TextTest : BasePaparazziTest() {
    override val thumbnailData: Snapshot
        get() = Snapshot(Component.Logo) { Thumbnail() }

    @Composable
    private fun Thumbnail() {
        TextTests()
    }
}