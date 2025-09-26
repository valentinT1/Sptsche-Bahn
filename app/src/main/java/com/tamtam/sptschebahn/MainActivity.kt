package com.tamtam.sptschebahn

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tamtam.sptschebahn.AppConstants.BUTTON_MAX_WIDTH
import com.tamtam.sptschebahn.ui.component.DelayText
import com.tamtam.sptschebahn.ui.component.HeadlineText
import com.tamtam.sptschebahn.ui.component.MenuRow
import com.tamtam.sptschebahn.ui.theme.SptscheBahnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SptscheBahnTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "main",
                        modifier = Modifier.padding(innerPadding),
                    ) {
                        composable("main") {
                            MainScreen(
                                onAppIconClick = { navController.navigate("main") },
                                onAchievementClick = { navController.navigate("achievements") },
                            )
                        }
                        composable("achievements") {
                            AchievementsScreen(
                                onAppIconClick = { navController.navigate("main") },
                                onAchievementClick = { navController.navigate("achievements") },
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onAppIconClick: () -> Unit = {},
    onAchievementClick: () -> Unit = {},
) {
    val allTimeDelayMinutes = AppConstants.DEFAULT_ALL_TIME_DELAY_MINUTES
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePickerLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent(),
        ) { uri: Uri? ->
            selectedImageUri = uri
            if (uri != null) {
                Log.d("ImagePicker", "Selected Image URI: $uri")
                // TODO: Add logic to process/upload the QR code image from this URI
            }
        }

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MenuRow(
            onAppIconClick = onAppIconClick,
            onAchievementClick = onAchievementClick,
        )

        Spacer(modifier = Modifier.height(50.dp))

        HeadlineText()
        Spacer(modifier = Modifier.height(20.dp))
        DelayText(minutes = allTimeDelayMinutes)

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                imagePickerLauncher.launch("image/*")
            },
            modifier =
                Modifier
                    .fillMaxWidth(BUTTON_MAX_WIDTH)
                    .height(60.dp),
        ) {
            Text(text = stringResource(id = R.string.upload_qr_button_label))
        }
    }
}

@Preview(showBackground = true, name = "Light Mode")
@Composable
fun MainScreenLightPreview() {
    SptscheBahnTheme(darkTheme = false) {
        Scaffold { innerPadding ->
            MainScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Preview(showBackground = true, name = "Dark Mode")
@Composable
fun MainScreenDarkPreview() {
    SptscheBahnTheme(darkTheme = true) {
        Scaffold { innerPadding ->
            MainScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}
