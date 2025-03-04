package ru.aigineer.aigineer.service

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.aigineer.aigineer.config.GIGA_CHAT_REST_TEMPLATE_BEAN_NAME

@Service
class GigaChatService(
    @Qualifier(GIGA_CHAT_REST_TEMPLATE_BEAN_NAME)
    private val restTemplate: RestTemplate,
    private val tokenManager: TokenManager
) {

    fun sendMessage(message: String) : String {
        val token = tokenManager.getToken()
        return token
    }
}