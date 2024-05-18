package com.example.app.presentation.feature.home.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.presentation.feature.home.event.HomeEvent
import com.example.app.presentation.feature.home.state.HomeState
import com.example.domain.usecase.GetUserUseCase
import com.example.domain.util.ApiResponseStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    var state by mutableStateOf(HomeState())


    internal fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnButtonClick -> getUserName(event.text)
            is HomeEvent.OnTextChanged -> state = state.copy(userName = event.text)
        }
    }

    private fun getUserName(userName: String) {
        viewModelScope.launch {
            state = when (val result = getUserUseCase(userName = userName)) {
                is ApiResponseStatus.Success -> {
                    state.copy(userName = result.data.userName, honor = result.data.honor)
                }

                is ApiResponseStatus.Failure -> {
                    Log.e("", result.failure.data.toString())
                    state
                }
            }
        }
    }
}