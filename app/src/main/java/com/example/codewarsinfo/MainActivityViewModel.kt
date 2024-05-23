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

    private val _showSplash = MutableStateFlow(true)
    val showSplash: StateFlow<Boolean> = _showSplash

    private val _userName = MutableStateFlow("")
    val userName: StateFlow<String> = _userName

    init {
        viewModelScope.launch {
            getUserConnected()
        }
    }

    private suspend fun getUserConnected() {
        getUserConnectedPreferencesUseCase().collect {
            _userName.value = it.ifEmpty {
                ""
            }
            _showSplash.value = false
        }
    }
}