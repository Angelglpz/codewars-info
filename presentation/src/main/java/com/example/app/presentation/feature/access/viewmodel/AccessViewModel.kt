package com.example.app.presentation.feature.access.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.app.presentation.feature.access.event.HomeEvent
import com.example.app.presentation.feature.access.state.AccessState
import com.example.app.presentation.util.KeepConnectedArgument
import com.example.domain.usecase.GetUserConnectedPreferencesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccessViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(AccessState())

    internal fun onEvent(event: HomeEvent) {
        state = when (event) {
            is HomeEvent.OnTextChanged -> state.copy(userName = event.text)
            is HomeEvent.OnCheckedChanged -> state.copy(keepConnectedChecked = event.checked)
        }
    }
}