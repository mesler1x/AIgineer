package ru.aigineer.aigineer.model.dto

import java.util.UUID

class PromptRequest(
    val mainContent: String,
    val celebrationId: UUID,
    val toneId: UUID,
    val styleType: UUID,
    val receiverName: String
) {
}