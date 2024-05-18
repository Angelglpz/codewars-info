package com.example.data.mapper

import com.example.domain.model.user.CodeChallenges
import com.example.domain.model.user.Rank
import com.example.domain.model.user.Ranks
import com.example.domain.model.user.User
import com.example.data.dto.user.CodeChallengesDTO
import com.example.data.dto.user.RankDTO
import com.example.data.dto.user.RanksDTO
import com.example.data.dto.user.UserDTOResponse

fun UserDTOResponse.toModel(): User =
    User(
        userName = userName,
        name = name ?: "",
        honor = honor,
        leaderboardPosition = leaderboardPosition,
        skills = skills ?: emptyList(),
        ranks = ranks?.toModel(),
        codeChallenges = codeChallenges?.toModel()
    )

fun RanksDTO.toModel(): Ranks =
    Ranks(
        overall = overall?.toModel(),
        languages = languages?.mapValues { it.value.toModel() })

fun RankDTO.toModel(): Rank =
    Rank(rank = rank, name = name ?: "", color = color ?: "", score = score)
fun CodeChallengesDTO.toModel(): CodeChallenges =
    CodeChallenges(
        totalAuthored = totalAuthored,
        totalCompleted = totalCompleted
    )
