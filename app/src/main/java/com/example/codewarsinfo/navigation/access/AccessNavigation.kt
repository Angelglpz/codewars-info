package com.example.codewarsinfo.navigation.access

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.app.presentation.feature.access.screen.AccessRoute
import com.example.codewarsinfo.navigation.NavigationRoute

fun NavGraphBuilder.addAccessNavigation(navController: NavController) {
    // A composable destination for the Access route.
    composable(route = NavigationRoute.Access.route) {
        AccessRoute(onContinueButtonClicked = { userName, keepConnected ->
            // Navigate to the Home route with the username and keepConnected parameters when the Continue button is clicked.
            navController.navigate(NavigationRoute.Home.navigateWithArgument(userName, keepConnected))
        })
    }
}