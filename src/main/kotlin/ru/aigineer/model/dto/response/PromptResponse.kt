package ru.aigineer.model.dto.response

import java.util.UUID

class PromptResponse(
    val id: UUID,
    val content: String,
    val promptType: String,
    val llmServiceId: UUID,
    val deleted: Boolean,
) {

}