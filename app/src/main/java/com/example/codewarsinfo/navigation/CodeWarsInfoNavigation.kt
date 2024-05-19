package com.example.codewarsinfo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.app.presentation.feature.access.screen.AccessRoute
import com.example.app.presentation.feature.home.screen.HomeRoute
import com.example.app.presentation.util.Argument

@Composable
fun CodeWarsInfoNavigation(startDestination: String = NavigationRoute.Access.route) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = NavigationRoute.Access.route) {
            AccessRoute(onContinueButtonClicked = {
                navController.navigate(NavigationRoute.Home.navigateWithArgument(it))
            })
        }
        composable(
            route = NavigationRoute.Home.route, arguments = listOf(
                navArgument(Argument) {
                    type = NavType.StringType
                })
        ) {
            HomeRoute()
        }
    }
}