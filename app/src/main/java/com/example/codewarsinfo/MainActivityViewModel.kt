package com.example.codewarsinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codewarsinfo.navigation.NavigationRoute
import com.example.domain.usecase.GetUserConnectedPreferencesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MainActivityViewModel @Inject constructor(
    private val getUserConnectedPreferencesUseCase: GetUserConnectedPreferencesUseCase
) : ViewModel() {

    var showSplash = true
        private set

    var startScreenNavigationRoute = NavigationRoute.Access.route
        private set

    init {
        viewModelScope.launch {
            getUserConnected()
        }
    }

    private suspend fun getUserConnected() {
        getUserConnectedPreferencesUseCase().collect {
            startScreenNavigationRoute = if (it.isNotEmpty()) {
                // If user was saved, keepConnected keep on true
                NavigationRoute.Home.navigateWithArgument(it, true)
            } else {
                NavigationRoute.Access.route
            }
            showSplash = false
        }
    }
}