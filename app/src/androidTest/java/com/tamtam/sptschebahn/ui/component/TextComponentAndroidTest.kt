package com.tamtam.sptschebahn.ui.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tamtam.sptschebahn.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TextComponentAndroidTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<androidx.activity.ComponentActivity>()

    @Test
    fun headlineText_displaysCorrectString() {
        composeTestRule.setContent {
            HeadlineText()
        }
        val expected = composeTestRule.activity.getString(R.string.all_time_delay_label)
        composeTestRule.onNodeWithText(expected).assertIsDisplayed()
    }

    @Test
    fun delayText_displaysMinutesAndUnit() {
        val minutes = 42
        composeTestRule.setContent {
            DelayText(minutes = minutes)
        }
        // Check the display of the minutes
        composeTestRule.onNodeWithText("$minutes").assertIsDisplayed()
        // Check the unit text
        val unit = composeTestRule.activity.getString(R.string.minutes_unit)
        composeTestRule.onNodeWithText(unit).assertIsDisplayed()
    }
}
