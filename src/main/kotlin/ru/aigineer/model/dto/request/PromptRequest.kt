package ru.aigineer.model.dto.request

import org.jetbrains.annotations.NotNull
import java.util.*

class PromptRequest(
    @field:NotNull
    val serviceId: UUID,
    @field:NotNull
    val celebrationId: UUID,
    @field:NotNull
    val toneId: UUID,
    @field:NotNull
    val styleId: UUID,
    @field:NotNull
    val receiverName: String,
    val additionalWishes: String?
)