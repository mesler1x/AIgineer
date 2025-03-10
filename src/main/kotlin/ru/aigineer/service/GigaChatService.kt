package ru.aigineer.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class GigaChatService(
    @Qualifier(ru.aigineer.config.GIGA_CHAT_REST_TEMPLATE_BEAN_NAME)
    private val restTemplate: RestTemplate,
    private val tokenManager: ru.aigineer.service.TokenManager,
    private val objectMapper: ObjectMapper = ObjectMapper().registerKotlinModule()
) {

    fun sendMessage(promptRequest: ru.aigineer.model.dto.request.PromptRequest): ru.aigineer.model.dto.response.PromptResponse {
        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_JSON
            accept = listOf(MediaType.APPLICATION_JSON)
            setBearerAuth(tokenManager.getToken())
        }
        val request = ru.aigineer.model.dto.request.CompletionRequest(
            model = ru.aigineer.model.GigaChatModel.GIGA_CHAT,
            messages = listOf(
                ru.aigineer.model.Message(ru.aigineer.model.GigaChatRole.ROLE_USER, promptRequest.mainContent)
            ),
            temperature = 0.4
        )
        val requestEntity = HttpEntity(request, headers)
        val response = restTemplate.exchange(
            ru.aigineer.service.util.COMPLETIONS_URL,
            HttpMethod.POST,
            requestEntity,
            String::class.java
        )
        //TODO - serialize
        return objectMapper.readValue(response.body, ru.aigineer.model.dto.response.PromptResponse::class.java)
    }
}