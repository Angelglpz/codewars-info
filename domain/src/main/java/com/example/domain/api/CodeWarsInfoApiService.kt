package com.example.domain.api

import com.example.domain.response.user.UserDTOResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CodeWarsInfoApiService {
    @GET("users")
    suspend fun getUser(@Query("user") userName: String): UserDTOResponse
}