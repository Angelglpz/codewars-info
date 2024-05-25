package com.example.data.datasource

import com.example.data.mapper.toModel
import com.example.data.api.CodeWarsInfoApiService
import com.example.domain.exception.CustomFailure
import com.example.domain.model.user.User
import com.example.data.dto.user.UserDTOResponse
import com.example.domain.util.ApiResponseStatus
import com.example.domain.util.networkCall
import retrofit2.HttpException
import javax.inject.Inject

class CodeWarsDataSourceImpl @Inject constructor(
    private val apiService: CodeWarsInfoApiService
) : CodeWarsDataSource {
    override suspend fun getUser(
        userName: String
    ): ApiResponseStatus<User> {

        return try {
            apiService.getUser(userName = userName).let {
                ApiResponseStatus.Success(it.toModel())
            }
        } catch (e: HttpException) {
            when (e.code()) {
                404 -> ApiResponseStatus.Failure(CustomFailure.UserNotFound)
                else -> ApiResponseStatus.Failure(CustomFailure.InternalServerError(e.message()))
            }
        } catch (e: Exception) {
            ApiResponseStatus.Failure(CustomFailure.GenericError)
        }
//        return when (val result = apiService.getUser(userName = userName)) {
//            is ApiResponseStatus.Success -> ApiResponseStatus.Success(result.data.toModel())
//            is ApiResponseStatus.Failure -> ApiResponseStatus.Failure(CustomFailure.InternalServerError(
//                result.failure.data.toString()
//            ))
//        }
    }
}