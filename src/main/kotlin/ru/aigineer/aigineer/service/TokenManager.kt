package ru.aigineer.aigineer.service

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.aigineer.aigineer.config.GIGA_CHAT_REST_TEMPLATE_BEAN_NAME
import ru.aigineer.aigineer.model.dto.AccessTokenResponse
import ru.aigineer.aigineer.service.util.AUTH_URL
import java.util.*

@Service
class TokenManager(
    @Qualifier(GIGA_CHAT_REST_TEMPLATE_BEAN_NAME)
    private val restTemplate: RestTemplate,
    private val objectMapper: ObjectMapper,
) {

    @Value("\${gigachat.auth-key}")
    private val authKey: String? = null
    private var expTime = 0L
    var refreshToken: String = ""

    @PostConstruct
    fun init() {
        getToken()
    }

    fun getToken(): String {
        if (isTokenExpired()) {
            val headers = HttpHeaders().apply {
                contentType = MediaType.APPLICATION_FORM_URLENCODED
                set("Accept", "application/json")
                set("RqUID", UUID.randomUUID().toString())
                set("Authorization", "Basic $authKey")
            }

            val body = "scope=GIGACHAT_API_PERS"
            val requestEntity = HttpEntity(body, headers)
            val response = restTemplate.exchange(AUTH_URL, HttpMethod.POST, requestEntity, String::class.java)
            val tokenResponse = objectMapper.readValue(response.body, AccessTokenResponse::class.java)
            expTime = tokenResponse.expiresAt
            refreshToken = tokenResponse.accessToken
        }

        return refreshToken
    }

    fun isTokenExpired(): Boolean = System.currentTimeMillis() + 3000L >= expTime
}