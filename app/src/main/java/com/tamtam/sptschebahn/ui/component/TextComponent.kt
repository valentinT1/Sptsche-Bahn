package com.tamtam.sptschebahn.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import com.tamtam.sptschebahn.R

@Composable
fun HeadlineText() {
    Text(
        text = stringResource(id = R.string.all_time_delay_label),
        style = MaterialTheme.typography.headlineSmall,
        color = MaterialTheme.colorScheme.onBackground,
    )
}

@Composable
fun DelayText(minutes: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = "$minutes",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            text = stringResource(id = R.string.minutes_unit),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}
