package ru.aigineer.model.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

class AccessTokenResponse(
    @field:JsonProperty("access_token")
    val accessToken: String,
    @field:JsonProperty("expires_at")
    val expiresAt: Long
)