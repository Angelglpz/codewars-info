package com.example.domain.repository

import com.example.domain.model.user.User
import com.example.data.user.UserDTOResponse
import com.example.domain.util.ApiResponseStatus


interface UserRepository {
    suspend fun getUser(userName: String): ApiResponseStatus<User>
}