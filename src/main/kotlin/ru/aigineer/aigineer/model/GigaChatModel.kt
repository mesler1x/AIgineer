package ru.aigineer.aigineer.model

import com.fasterxml.jackson.annotation.JsonValue

enum class GigaChatModel(@JsonValue val model: String) {
    GIGA_CHAT("GigaChat"),
    GIGA_CHAT_PRO("GigaChat-Pro"),
    GIGA_CHAT_MAX("GigaChat-Max")
}