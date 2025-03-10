package ru.aigineer.model

import com.fasterxml.jackson.annotation.JsonValue

enum class GigaChatRole(@JsonValue val role: String) {
    ROLE_SYSTEM("system"),
    ROLE_USER("user"),
    ROLE_ASSISTANT("assistant"),
    ROLE_FUNCTION("function")
}