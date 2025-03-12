package ru.aigineer.model.dto.request

import ru.aigineer.model.GigaChatModel
import ru.aigineer.model.Message

class CompletionRequest(
    val model: GigaChatModel,
    val messages: List<Message>,
    val temperature: Double
) {
}