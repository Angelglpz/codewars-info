package com.example.domain.mapper

import com.example.app.presentation.model.user.CodeChallenges
import com.example.app.presentation.model.user.Rank
import com.example.app.presentation.model.user.Ranks
import com.example.app.presentation.model.user.User
import com.example.domain.response.user.CodeChallengesDTO
import com.example.domain.response.user.RankDTO
import com.example.domain.response.user.RanksDTO
import com.example.domain.response.user.UserDTOResponse

fun UserDTOResponse.toModel(): User =
    User(
        userName = userName,
        name = name,
        honor = honor,
        leaderboardPosition = leaderboardPosition,
        skills = skills,
        ranks = ranks.toModel(),
        codeChallenges = codeChallenges.toModel()
    )

fun RanksDTO.toModel(): Ranks =
    Ranks(overall = overall.toModel(), languages = languages.mapValues { it.value.toModel() })

fun RankDTO.toModel(): Rank = Rank(rank = rank, name = name, color = color, score = score)
fun CodeChallengesDTO.toModel(): CodeChallenges =
    CodeChallenges(totalAuthored = totalAuthored, totalCompleted = totalCompleted)
