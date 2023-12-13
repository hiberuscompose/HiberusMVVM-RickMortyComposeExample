package com.hiberus.template.presentation.ui.composetesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.hiberus.template.presentation.ui.compose.ui.theme.HiberusTemplateTheme
import com.hiberus.template.presentation.ui.composetesting.screen.TestingComposeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestingComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiberusTemplateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TestingComposeScreen()
                }
            }
        }
    }
}