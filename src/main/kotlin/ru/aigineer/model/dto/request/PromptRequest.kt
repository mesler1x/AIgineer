package ru.aigineer.model.dto.request

import java.util.*

class PromptRequest(
    val mainContent: String,
    val serviceId: String,
    val celebrationId: UUID,
    val toneId: UUID,
    val styleType: UUID,
    val receiverName: String
) {
}