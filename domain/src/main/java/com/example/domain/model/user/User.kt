package com.example.domain.model.user

data class User(
    val userName: String,
    val name: String,
    val honor: Int?,
    val leaderboardPosition: Int?,
    val skills: List<String>,
    val ranks: Ranks?,
    val codeChallenges: CodeChallenges?
)