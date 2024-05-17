package com.example.app.presentation.model.user

data class Ranks(
    val overall: Rank,
    val languages: Map<String, Rank>
)