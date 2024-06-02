package com.example.codewarsinfo.navigation.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.app.presentation.feature.home.screen.HomeRoute
import com.example.codewarsinfo.navigation.NavigationRoute

fun NavGraphBuilder.addHomeNavigation(navController: NavController) {
    // A composable destination for the Home route, with arguments for the username and keepConnected parameters.
    composable(
        route = NavigationRoute.Home.route, arguments = NavigationRoute.Home.arguments
    ) {
        HomeRoute()
    }
}