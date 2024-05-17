package com.example.domain.response.user

data class RanksDTO(
    val overall: RankDTO,
    val languages: Map<String, RankDTO>
)
