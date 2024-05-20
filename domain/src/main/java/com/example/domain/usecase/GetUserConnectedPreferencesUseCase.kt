package com.example.domain.usecase

import com.example.domain.model.userdata.UserData
import com.example.domain.repository.UserPreferencesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserConnectedPreferencesUseCase @Inject constructor(
    private val preferencesRepository: UserPreferencesRepository
) {
    suspend operator fun invoke(): Flow<String> = preferencesRepository.getUserName()
}