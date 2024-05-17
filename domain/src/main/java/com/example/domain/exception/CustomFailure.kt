package com.example.domain.exception

sealed class CustomFailure(data: String) {
    data object GenericError: CustomFailure("Generic error")
    class InternalServerError(data: String): CustomFailure(data)
}