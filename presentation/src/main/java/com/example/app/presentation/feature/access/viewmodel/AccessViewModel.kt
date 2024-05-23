package com.example.app.presentation.feature.access.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.app.presentation.feature.access.event.AccessEvent
import com.example.app.presentation.feature.access.state.AccessState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccessViewModel @Inject constructor() : ViewModel() {

    var state by mutableStateOf(AccessState())

    internal fun onEvent(event: AccessEvent) {
        state = when (event) {
            is AccessEvent.OnTextChanged -> state.copy(userName = event.text)
            is AccessEvent.OnCheckedChanged -> state.copy(keepConnectedChecked = event.checked)
        }
    }
}