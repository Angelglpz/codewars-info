package com.example.codewarsinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetUserConnectedPreferencesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getUserConnectedPreferencesUseCase: GetUserConnectedPreferencesUseCase
) : ViewModel() {

    var showSplash = true
        private set


    init {
        viewModelScope.launch {
            getUserConnected()
        }
    }

    private suspend fun getUserConnected(): String =
        getUserConnectedPreferencesUseCase().first { it.isNotEmpty() }
}