package com.example.data.dto.user

data class RanksDTO(
    val overall: RankDTO?,
    val languages: Map<String, RankDTO>?
)
