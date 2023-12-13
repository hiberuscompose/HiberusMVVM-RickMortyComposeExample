package com.hiberus.template.presentation.ui.paparazzi.screen.samples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 *   @author xavierjimenez
 *   @since 13/12/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */

@Preview
@Composable
fun ButtonTest() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(contentColor = Color.Red)
        ) {
            Text(text = "Color Red")
        }

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(contentColor = Color.Blue)
        ) {
            Text(text = "Color Blue")
        }

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(contentColor = Color.Green)
        ) {
            Text(text = "Color Green")
        }
    }
}