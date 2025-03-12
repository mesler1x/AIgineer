package ru.aigineer.controller.exception

class ApiErrorResponse(
    private val errorCode: Int,
    private val errorMessage: String
) {
}