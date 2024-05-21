package com.example.domain.repository

import kotlinx.coroutines.flow.Flow

interface UserPreferencesRepository {
    suspend fun getUserName(): Flow<String>
    suspend fun saveUserName(userName: String)
}