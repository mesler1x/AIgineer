package ru.aigineer.aigineer.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.aigineer.aigineer.config.GIGA_CHAT_REST_TEMPLATE_BEAN_NAME
import ru.aigineer.aigineer.model.GigaChatModel
import ru.aigineer.aigineer.model.GigaChatRole
import ru.aigineer.aigineer.model.Message
import ru.aigineer.aigineer.model.dto.CompletionRequest
import ru.aigineer.aigineer.model.dto.PromptRequest
import ru.aigineer.aigineer.model.dto.PromptResponse
import ru.aigineer.aigineer.service.util.COMPLETIONS_URL

@Service
class GigaChatService(
    @Qualifier(GIGA_CHAT_REST_TEMPLATE_BEAN_NAME)
    private val restTemplate: RestTemplate,
    private val tokenManager: TokenManager,
    private val objectMapper: ObjectMapper = ObjectMapper().registerKotlinModule()
) {

    fun sendMessage(promptRequest: PromptRequest) : PromptResponse {
        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_JSON
            accept = listOf(MediaType.APPLICATION_JSON)
            setBearerAuth(tokenManager.getToken())
        }
        val request = CompletionRequest(
            model = GigaChatModel.GIGA_CHAT,
            messages = listOf(
                Message(GigaChatRole.ROLE_USER, promptRequest.mainContent)
            ),
            temperature = 0.4
        )
        val requestEntity = HttpEntity(request, headers)
        val response = restTemplate.exchange(COMPLETIONS_URL, HttpMethod.POST, requestEntity, String::class.java)
        //TODO - serialize
        return objectMapper.readValue(response.body, PromptResponse::class.java)
    }
}