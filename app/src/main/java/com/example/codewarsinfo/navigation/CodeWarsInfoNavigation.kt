package com.example.codewarsinfo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.app.presentation.feature.access.screen.AccessRoute
import com.example.app.presentation.feature.home.screen.HomeRoute
import com.example.app.presentation.util.KeepConnectedArgument
import com.example.app.presentation.util.UserNameArgument

@Composable
fun CodeWarsInfoNavigation(userName: String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationRoute.Intermediate.route) {
        composable(route = NavigationRoute.Intermediate.route) {
            // Navigate immediately to the route with parameters
            LaunchedEffect(Unit) {
                if (userName.isEmpty()) {
                    navController.navigate(NavigationRoute.Access.route)
                } else {
                    navController.navigate(
                        NavigationRoute.Home.navigateWithArgument(
                            userName = userName,
                            keepConnected = true
                        )
                    )
                }
            }
        }
        composable(route = NavigationRoute.Access.route) {
            AccessRoute(onContinueButtonClicked = { userName, keepConnected ->
                navController.navigate(NavigationRoute.Home.navigateWithArgument(userName, keepConnected))
            })
        }
        composable(
            route = NavigationRoute.Home.route, arguments = listOf(
                navArgument(UserNameArgument) {
                    type = NavType.StringType
                },
                navArgument(KeepConnectedArgument) {
                    type = NavType.BoolType
                }
            )
        ) {
            HomeRoute()
        }
    }
}