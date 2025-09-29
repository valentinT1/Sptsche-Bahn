package com.tamtam.sptschebahn.ui.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.tamtam.sptschebahn.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AchievementsScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun menuRow_andText_areDisplayed() {
        composeTestRule.setContent {
            AchievementsScreen()
        }
        // Check MenuRow's profile picture (as a proxy for MenuRow existence)
        composeTestRule
            .onNodeWithContentDescription(
                context.getString(R.string.profile_picture),
            ).assertIsDisplayed()
        // Check the main text
        composeTestRule.onNodeWithText("Here will be excuses and achievements").assertIsDisplayed()
    }

    @Test
    fun appIconClick_triggersCallback() {
        var clicked = false
        composeTestRule.setContent {
            AchievementsScreen(onAppIconClick = { clicked = true })
        }
        composeTestRule
            .onNodeWithContentDescription(
                context.getString(R.string.app_logo_content_description),
            ).performClick()
        assert(clicked)
    }

    @Test
    fun achievementIconClick_triggersCallback() {
        var clicked = false
        composeTestRule.setContent {
            AchievementsScreen(onAchievementClick = { clicked = true })
        }
        composeTestRule
            .onNodeWithContentDescription(
                context.getString(R.string.achievements),
            ).performClick()
        assert(clicked)
    }
}
