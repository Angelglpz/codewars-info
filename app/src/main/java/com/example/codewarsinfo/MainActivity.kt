package com.example.codewarsinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.app.presentation.theme.CodeWarsInfoTheme
import com.example.app.presentation.theme.PaddingSmall
import com.example.codewarsinfo.navigation.CodeWarsInfoNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition {
            viewModel.showSplash
        }
        enableEdgeToEdge()
        setContent {
            CodeWarsInfoTheme(dynamicColor = false) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(PaddingSmall)
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        CodeWarsInfoNavigation()
                    }
                }
            }
        }
    }
}