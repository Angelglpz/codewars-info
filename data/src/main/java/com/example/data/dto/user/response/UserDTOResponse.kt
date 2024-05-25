package com.example.data.dto.user.response

import com.example.data.dto.user.CodeChallengesDTO
import com.example.data.dto.user.RanksDTO
import com.squareup.moshi.Json

data class UserDTOResponse(
    @Json(name = "username") val userName: String,
    val name: String?,
    val honor: Int?,
    val leaderboardPosition: Int?,
    val skills: List<String>?,
    val ranks: RanksDTO?,
    val codeChallenges: CodeChallengesDTO?
)