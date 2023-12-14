package com.hiberus.template.presentation.ui.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Immutable
data class MyItem(val id: String, val name: String)
@Preview(showSystemUi = true)
@Composable
fun Screen(){
var isExpanded by remember {
    mutableStateOf(false)
}

    val expandedState by remember {
        mutableStateMapOf<String, Boolean>()
    }

    MyComposable(title = "hola", description = "que tal", isExpanded = isExpanded,
        expandedContent = { Text(text = "Expandido")}) {
        isExpanded = !isExpanded
    }
}

@Composable
fun MyComposable(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    isExpanded: Boolean,
    expandedContent: @Composable () -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier.clickable { onClick() },

        ) {
        Text(
            text = title,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = description,
            modifier = Modifier.fillMaxWidth()
        )
        if (isExpanded) {
            expandedContent()
        }
    }
}