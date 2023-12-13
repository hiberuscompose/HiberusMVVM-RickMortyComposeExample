package com.hiberus.template.presentation.ui.composetesting.screen

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TestingComposeScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Testing Compose")
                }
            )
        }
    ) { paddingValues ->
        TestingView(paddingValues = paddingValues)
    }
}
