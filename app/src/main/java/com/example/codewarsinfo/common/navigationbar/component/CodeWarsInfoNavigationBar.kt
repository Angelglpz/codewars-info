package com.example.codewarsinfo.common.navigationbar.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.codewarsinfo.common.navigationbar.viewmodel.CodeWarsInfoNavigationBarViewModel
import com.example.codewarsinfo.navigation.NavigationRoute

@Composable
internal fun CodeWarsNavigationBar(
    viewModel: CodeWarsInfoNavigationBarViewModel = hiltViewModel(),
    navController: NavController,
    userName: String
) {

    val items = listOf(
        NavigationRoute.Home,
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
                            navController.navigate(screen.navigateWithArgument(userName, false))

                        } else {
                            navController.navigate(screen.route)
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
