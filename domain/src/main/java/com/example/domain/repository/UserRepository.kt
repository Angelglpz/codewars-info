package com.example.domain.repository

import com.example.app.presentation.model.user.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUser(userName: String): Flow<User> // ?????
}