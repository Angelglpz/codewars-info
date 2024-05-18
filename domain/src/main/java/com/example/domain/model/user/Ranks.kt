package com.example.domain.model.user

data class Ranks(
    val overall: Rank?,
    val languages: Map<String, Rank>?
)