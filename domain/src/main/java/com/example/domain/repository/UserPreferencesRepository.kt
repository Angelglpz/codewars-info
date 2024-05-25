package com.example.domain.repository

import kotlinx.coroutines.flow.Flow

interface UserPreferencesRepository {
    fun getUserName(): Flow<String>
    suspend fun saveUserName(userName: String)
}