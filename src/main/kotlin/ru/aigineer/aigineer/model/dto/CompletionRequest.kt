package ru.aigineer.aigineer.model.dto

import ru.aigineer.aigineer.model.GigaChatModel
import ru.aigineer.aigineer.model.Message

class CompletionRequest(
    val model: GigaChatModel,
    val messages: List<Message>,
    val temperature: Double
) {
}