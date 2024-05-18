package com.example.data.user

data class RanksDTO(
    val overall: RankDTO,
    val languages: Map<String, RankDTO>
)
