package ru.aigineer.model.dto.response

import java.util.UUID

class ServiceResponse(
    val id: UUID,
    val serviceName: String,
    val serviceDescription: String,
) {
}