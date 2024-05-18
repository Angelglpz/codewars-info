package com.example.domain.usecase

import com.example.domain.model.user.User
import com.example.domain.repository.IUserRepository
import com.example.domain.util.ApiResponseStatus
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: IUserRepository
) {
    suspend operator fun invoke(userName: String): ApiResponseStatus<User> {
        return userRepository.getUser(userName = userName)
    }
}