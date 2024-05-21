package com.example.domain.usecase

import com.example.domain.repository.UserPreferencesRepository
import javax.inject.Inject

class SaveUserConnectedPreferencesUseCase @Inject constructor(
    private val preferencesRepository: UserPreferencesRepository
) {
    suspend operator fun invoke(userName: String) {
        preferencesRepository.saveUserName(userName)
    }
}