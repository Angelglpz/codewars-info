package com.example.domain.datasource

import com.example.domain.api.CodeWarsInfoApiService
import com.example.domain.response.user.UserDTOResponse
import com.example.domain.util.ApiResponseStatus

interface CodeWarsDataSource {
    suspend fun getUser(apiService: CodeWarsInfoApiService, userName: String): ApiResponseStatus<UserDTOResponse>
}