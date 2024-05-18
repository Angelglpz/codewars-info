package com.example.domain.repository

import com.example.domain.model.user.User
import com.example.domain.util.ApiResponseStatus


interface IUserRepository {
    suspend fun getUser(userName: String): ApiResponseStatus<User>
}