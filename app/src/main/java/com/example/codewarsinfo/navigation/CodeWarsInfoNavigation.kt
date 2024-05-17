package com.example.codewarsinfo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app.presentation.feature.home.screen.HomeScreen

@Composable
fun CodeWarsInfoNavigation() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = HomeScreenDestination) {
        composable(route = HomeScreenDestination) {
            HomeScreen()
        }
    }
}