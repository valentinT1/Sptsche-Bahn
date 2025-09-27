package com.tamtam.sptschebahn.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tamtam.sptschebahn.AppConstants.PADDING_16
import com.tamtam.sptschebahn.AppConstants.SPACER_HEIGHT_50
import com.tamtam.sptschebahn.ui.component.MenuRow

@Composable
fun AchievementsScreen(
    modifier: Modifier = Modifier,
    onAppIconClick: () -> Unit = {},
    onAchievementClick: () -> Unit = {},
) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(PADDING_16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MenuRow(
            onAppIconClick = onAppIconClick,
            onAchievementClick = onAchievementClick,
        )
        Spacer(modifier = Modifier.height(SPACER_HEIGHT_50.dp))
        Text(text = "Here will be excuses and achievements")
    }
}
