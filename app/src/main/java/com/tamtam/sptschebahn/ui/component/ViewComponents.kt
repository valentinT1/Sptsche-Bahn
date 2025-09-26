package com.tamtam.sptschebahn.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tamtam.sptschebahn.R

@Composable
fun MenuRow(
    modifier: Modifier = Modifier,
    onAppIconClick: () -> Unit,
    onAchievementClick: () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = onAppIconClick,
            modifier = Modifier.size(64.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_icon),
                contentDescription = stringResource(id = R.string.app_logo_content_description),
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Fit,
            )
        }
        IconButton(onClick = onAchievementClick) {
            Image(
                painter = painterResource(id = R.drawable.achievement_icon),
                contentDescription = stringResource(id = R.string.achievements),
                modifier = Modifier.size(48.dp),
            )
        }
        Box(
            modifier =
                Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceVariant),
        )
    }
}
