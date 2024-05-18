package com.example.data.datasource

import com.example.domain.model.user.User
import com.example.data.dto.user.UserDTOResponse
import com.example.domain.util.ApiResponseStatus

interface CodeWarsDataSource {
    suspend fun getUser(userName: String): ApiResponseStatus<User>
}