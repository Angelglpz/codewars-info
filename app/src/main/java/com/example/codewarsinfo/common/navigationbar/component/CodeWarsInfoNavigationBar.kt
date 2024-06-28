package com.example.codewarsinfo.common.navigationbar.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import com.example.codewarsinfo.MainActivityViewModel
import com.example.codewarsinfo.UserConfigState
import com.example.codewarsinfo.common.navigationbar.viewmodel.CodeWarsInfoNavigationBarViewModel
import com.example.codewarsinfo.navigation.NavigationRoute

@Composable
internal fun CodeWarsNavigationBar(
    navController: NavController,
    viewModel: MainActivityViewModel
) {

    val items = listOf(
        NavigationRoute.Home,
        NavigationRoute.Access
    )
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    if (currentRoute == NavigationRoute.Home.route) {
        NavigationBar {
            items.forEach { screen ->
                NavigationBarItem(
                    selected = currentRoute == screen.route,
                    onClick = {
                        if (screen.route == NavigationRoute.Home.route) {
                            navController.codeWarsBarNavigate(
                                route = (screen as NavigationRoute.Home).navigateWithArgument(
                                    viewModel.userConfigState.userName,
                                    false
                                )
                            )

                        } else {
                            navController.codeWarsBarNavigate(screen.route)
                        }
                    },
                    label = { screen.label?.let { stringResource(id = it) } },
                    icon = {
                        screen.icon?.let {
                            Icon(
                                imageVector = it,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    })
            }
        }
    }
}

internal fun NavController.codeWarsBarNavigate(route: String) {
    this.navigate(route = route, navOptions = navOptions {
        launchSingleTop = true
        popUpTo(graph.findStartDestination().id)
    })
}
