package com.hiberus.template.presentation.ui

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hiberus.template.presentation.ui.compose.ui.theme.HiberusTemplateTheme
import com.hiberus.template.presentation.ui.composetesting.screen.TestingView
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
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
        Thread.sleep(1000)
    }

    @Test
    fun textWithTextIsDisplayed() {
        composeTestRule.onNodeWithText(HELLO).isDisplayed()
        Thread.sleep(1000)
    }

    @Test
    fun textWithTextNotContainsHelloWorld() {
        composeTestRule.onNodeWithText(HELLO_WORLD).assertDoesNotExist()
        Thread.sleep(1000)
    }

    @Test
    fun textAfterClickButtonDisplayHelloWorld() {
        with(composeTestRule) {
            onNodeWithTag(TEXT_ID).assertTextEquals(HELLO)
            Thread.sleep(1000)
            onNodeWithTag(BUTTON_ID).performClick()
            onNodeWithTag(TEXT_ID).assertTextEquals(HELLO_WORLD)
        }
        Thread.sleep(1000)
    }
}

private const val HELLO = "Hello"
private const val HELLO_WORLD = "$HELLO World"
private const val TEXT_ID = "TextId"
private const val BUTTON_ID = "ButtonId"