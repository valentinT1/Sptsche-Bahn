package com.tamtam.sptschebahn.ui.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.tamtam.sptschebahn.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MenuRowTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun appIcon_isDisplayed_andClickable() {
        var clicked = false
        composeTestRule.setContent {
            MenuRow(
                onAppIconClick = { clicked = true },
                onAchievementClick = {},
                profilePictureResId = R.drawable.default_user_picture,
            )
        }
        composeTestRule
            .onNodeWithContentDescription(
                context.getString(R.string.app_logo_content_description),
            ).assertIsDisplayed()
            .performClick()
        assert(clicked)
    }

    @Test
    fun achievementIcon_isDisplayed_andClickable() {
        var clicked = false
        composeTestRule.setContent {
            MenuRow(
                onAppIconClick = {},
                onAchievementClick = { clicked = true },
                profilePictureResId = R.drawable.default_user_picture,
            )
        }
        composeTestRule
            .onNodeWithContentDescription(
                context.getString(R.string.achievements),
            ).assertIsDisplayed()
            .performClick()
        assert(clicked)
    }

    @Test
    fun profilePicture_isDisplayed_withFallback() {
        composeTestRule.setContent {
            MenuRow(
                onAppIconClick = {},
                onAchievementClick = {},
                profilePictureResId = null,
            )
        }
        composeTestRule
            .onNodeWithContentDescription(
                context.getString(R.string.profile_picture),
            ).assertIsDisplayed()
    }

    @Test
    fun profilePicture_isDisplayed_withCustomResId() {
        composeTestRule.setContent {
            MenuRow(
                onAppIconClick = {},
                onAchievementClick = {},
                profilePictureResId = R.drawable.default_user_picture,
            )
        }
        composeTestRule
            .onNodeWithContentDescription(
                context.getString(R.string.profile_picture),
            ).assertIsDisplayed()
    }
}
