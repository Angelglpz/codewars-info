package com.example.data.user

import com.squareup.moshi.Json

data class UserDTOResponse(
    @field:Json(name = "username") val userName: String,
    val name: String,
    val honor: Int,
    val leaderboardPosition: Int,
    val skills: List<String>,
    val ranks: RanksDTO,
    val codeChallenges: CodeChallengesDTO
)