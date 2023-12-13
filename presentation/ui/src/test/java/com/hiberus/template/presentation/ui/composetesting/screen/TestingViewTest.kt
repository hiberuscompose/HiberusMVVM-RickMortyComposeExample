package com.hiberus.template.presentation.ui.composetesting.screen

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.hiberus.template.presentation.ui.compose.ui.theme.HiberusTemplateTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TestingViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        composeTestRule.setContent {
            HiberusTemplateTheme {
                TestingView()
            }
        }
    }

    @Test
    fun textWithTagDisplayHello() {
        composeTestRule.onNodeWithTag(TEXT_ID).assertTextEquals(HELLO)
    }
}

private const val HELLO = "Hello"
private const val WORLD = " World"
private const val BUTTON_TEXT = "Click me to add World"
private const val TESTING_VIEW_ID = "TestingViewId"
private const val TEXT_ID = "TextId"
private const val BUTTON_ID = "ButtonId"
private const val BUTTON_TEXT_ID = "ButtonTextId"
