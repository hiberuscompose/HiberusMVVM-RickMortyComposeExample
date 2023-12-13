package com.hiberus.template.presentation.ui.composetesting.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hiberus.template.presentation.ui.compose.ui.theme.Typography

/**
 *   @author xavierjimenez
 *   @since 13/12/23
 *   @email xavijimenezmulet@macaqueconsulting.com
 */

@Composable
internal fun TestingView(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf(EMPTY_STRING) }

    Column(
        modifier = modifier
            .testTag(TESTING_VIEW_ID)
            .padding(paddingValues)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(SPACED.dp)
    ) {
        Text(
            text = HELLO + text,
            modifier = Modifier
                .testTag(TEXT_ID)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = Typography.titleLarge
        )

        Button(
            onClick = {
                text = WORLD
            },
            modifier = Modifier
                .testTag(BUTTON_ID)
                .fillMaxWidth()
        ) {
            Text(
                text = BUTTON_TEXT,
                modifier = Modifier
                    .testTag(BUTTON_TEXT_ID)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestingViewPreview() {
    TestingView(paddingValues = PaddingValues())
}

private const val EMPTY_STRING = ""
private const val HELLO = "Hello"
private const val WORLD = " World"
private const val BUTTON_TEXT = "Click me to add World"
private const val TESTING_VIEW_ID = "TestingViewId"
private const val TEXT_ID = "TextId"
private const val BUTTON_ID = "ButtonId"
private const val BUTTON_TEXT_ID = "ButtonTextId"
private const val SPACED = 10
