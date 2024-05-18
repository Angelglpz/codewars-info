package com.example.data.api

import com.example.data.dto.user.UserDTOResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CodeWarsInfoApiService {
    @GET("users/{user}")
    suspend fun getUser(@Path("user") userName: String): UserDTOResponse
}