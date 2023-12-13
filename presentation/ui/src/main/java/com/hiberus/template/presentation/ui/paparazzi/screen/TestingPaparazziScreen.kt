package com.hiberus.template.presentation.ui.paparazzi.screen

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TestingPaparazziScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Storybook")
                }
            )
        }
    ) { paddingValues ->
        StorybookView(paddingValues = paddingValues)
    }
}