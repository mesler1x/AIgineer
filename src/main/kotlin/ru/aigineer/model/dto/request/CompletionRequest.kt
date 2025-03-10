package ru.aigineer.model.dto.request

class CompletionRequest(
    val model: ru.aigineer.model.GigaChatModel,
    val messages: List<ru.aigineer.model.Message>,
    val temperature: Double
) {
}