package com.example.domain.exception

sealed class CustomFailure(val data: Any? = null) {
    data object GenericError: CustomFailure(data = "Generic error")
    data object UserNotFound: CustomFailure(data = "User not found")
    class InternalServerError(data: String): CustomFailure(data)
}