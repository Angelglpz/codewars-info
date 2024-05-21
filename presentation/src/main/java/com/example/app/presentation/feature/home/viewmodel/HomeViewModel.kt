package com.example.app.presentation.feature.home.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.presentation.feature.home.state.HomeState
import com.example.app.presentation.util.KeepConnectedArgument
import com.example.app.presentation.util.UserNameArgument
import com.example.domain.usecase.GetUserUseCase
import com.example.domain.usecase.SaveUserConnectedPreferencesUseCase
import com.example.domain.util.ApiResponseStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getUserUseCase: GetUserUseCase,
    private val saveUserConnectedPreferencesUseCase: SaveUserConnectedPreferencesUseCase
) : ViewModel() {

    var state by mutableStateOf(HomeState())

    init {
        val userName: String = savedStateHandle[UserNameArgument] ?: ""
        getUserName(userName)
        val keepUserConnected: Boolean = savedStateHandle[KeepConnectedArgument] ?: false
        if (keepUserConnected) {
            saveUserName(userName)
        }
    }

    private fun saveUserName(userName: String) {
        viewModelScope.launch {
            saveUserConnectedPreferencesUseCase(userName)
        }
    }

    private fun getUserName(userName: String) {
        viewModelScope.launch {
            state = state.copy(showLoading = true)
            state = when (val result = getUserUseCase(userName = userName)) {
                is ApiResponseStatus.Success -> {
                    state.copy(
                        userName = result.data.userName,
                        honor = (result.data.honor ?: "").toString(),
                        showLoading = false
                    )
                }

                is ApiResponseStatus.Failure -> {
                    Log.e("", result.failure.data.toString())
                    state
                }
            }
        }
    }


}