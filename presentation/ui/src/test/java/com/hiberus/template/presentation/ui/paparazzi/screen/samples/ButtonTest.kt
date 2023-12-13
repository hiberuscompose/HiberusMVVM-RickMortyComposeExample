package com.hiberus.template.presentation.ui.paparazzi.screen.samples

import androidx.compose.runtime.Composable
import com.hiberus.template.core.common.entities.enums.Component
import com.hiberus.template.presentation.ui.BasePaparazziTest

class ButtonTest : BasePaparazziTest() {
    override val thumbnailData: Snapshot
        get() = Snapshot(Component.Button) { Thumbnail() }

    @Composable
    private fun Thumbnail() {
        ButtonTests()
    }

}