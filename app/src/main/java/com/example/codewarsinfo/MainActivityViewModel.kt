package com.example.codewarsinfo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

    private val _showSplash = MutableStateFlow(true)
    val showSplash: StateFlow<Boolean> = _showSplash

    var userName = MutableStateFlow("")

    var uiState by mutableStateOf<UIState>(UIState.Loading)
    var userConfigState = UserConfigState("", false)
        private set

    init {
        viewModelScope.launch {
            getUserConnected()
        }
    }

    private suspend fun getUserConnected() {
        getUserConnectedPreferencesUseCase().collect {
            userName.value = it.ifEmpty {
                ""
            }
            uiState = if (userName.value.isEmpty()) {
                UIState.Success(NavigationRoute.Access.route)
            } else {
                userConfigState = UserConfigState(userName.value, true)
                UIState.Success(NavigationRoute.Home.route)
            }
        }
    }

    fun editUserConfigState(userName: String, keepConnected: Boolean) {
        userConfigState = UserConfigState(userName, keepConnected)
    }
}