package com.tamtam.sptschebahn

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun mainScreen_isDisplayed() {
        val mainScreenText = composeTestRule.activity.getString(R.string.all_time_delay_label)
        composeTestRule
            .onNodeWithText(mainScreenText)
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText(composeTestRule.activity.getString(R.string.upload_qr_button_label))
            .assertIsDisplayed()
    }

    @Test
    fun clickAchievements_navigatesToAchievementsScreen() {
        val achievementsDesc = composeTestRule.activity.getString(R.string.achievements)
        composeTestRule
            .onAllNodes(hasContentDescription(achievementsDesc))
            .onFirst()
            .performClick()
        // Check the real text displayed on the Achievements screen
        composeTestRule
            .onNodeWithText("Here will be excuses and achievements")
            .assertIsDisplayed()
    }

    @Test
    fun clickAppIcon_navigatesBackToMainScreen() {
        val achievementsDesc = composeTestRule.activity.getString(R.string.achievements)
        composeTestRule
            .onAllNodes(hasContentDescription(achievementsDesc))
            .onFirst()
            .performClick()
        val appIconDesc = composeTestRule.activity.getString(R.string.app_logo_content_description)
        composeTestRule
            .onAllNodes(hasContentDescription(appIconDesc))
            .onFirst()
            .performClick()
        // Check the real text displayed on the Main screen
        val mainScreenText = composeTestRule.activity.getString(R.string.all_time_delay_label)
        composeTestRule
            .onNodeWithText(mainScreenText)
            .assertIsDisplayed()
    }

    @Test
    fun uploadQrButton_isClickable() {
        val buttonText = composeTestRule.activity.getString(R.string.upload_qr_button_label)
        composeTestRule
            .onNodeWithText(buttonText)
            .assertIsDisplayed()
            .assertHasClickAction()
    }

    @Test
    fun menuRow_displaysProfilePictureOrDefault() {
        // Verify that the profile picture or default icon is displayed
        composeTestRule
            .onAllNodes(
                hasContentDescription(composeTestRule.activity.getString(R.string.profile_picture)),
            ).onFirst()
            .assertIsDisplayed()
    }
}
