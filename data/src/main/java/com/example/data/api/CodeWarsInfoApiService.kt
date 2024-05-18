package com.example.data.api

import com.example.data.user.UserDTOResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CodeWarsInfoApiService {
    @GET("users")
    suspend fun getUser(@Query("user") userName: String): UserDTOResponse
}