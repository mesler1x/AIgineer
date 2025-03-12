package ru.aigineer.service

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.aigineer.config.GIGA_CHAT_REST_TEMPLATE_BEAN_NAME
import ru.aigineer.model.GigaChatModel
import ru.aigineer.model.dto.response.GigaChatResponse
import ru.aigineer.model.GigaChatRole
import ru.aigineer.model.Message
import ru.aigineer.model.dto.request.CompletionRequest
import ru.aigineer.model.dto.request.PromptRequest
import ru.aigineer.model.dto.response.CommonGenerativeContentResponse
import ru.aigineer.model.dto.response.PromptResponse
import ru.aigineer.service.util.COMPLETIONS_URL
import java.util.*

@Service
class GigaChatService(
    @Qualifier(GIGA_CHAT_REST_TEMPLATE_BEAN_NAME)
    private val restTemplate: RestTemplate,
    private val tokenManager: TokenManager,
    private val celebrationService: CelebrationService,
    private val toneService: ToneService,
    private val styleService: StyleService,
    private val promptService: PromptService,
) {

    fun sendMessage(promptRequest: PromptRequest): CommonGenerativeContentResponse {
        val celebration = celebrationService.findById(promptRequest.celebrationId)
        val tone = toneService.findById(promptRequest.toneId)
        val style = styleService.findById(promptRequest.styleId)
        val prompt = promptService.findByServiceId(promptRequest.serviceId)
        val content = String.format(
            prompt.content,
            celebration.name,
            promptRequest.receiverName,
            style.name, tone.name,
            promptRequest.additionalWishes
        )

        return performRequestToGigaChat(content)
    }

    private fun performRequestToGigaChat(content: String): CommonGenerativeContentResponse {
        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_JSON
            accept = listOf(MediaType.APPLICATION_JSON)
            setBearerAuth(tokenManager.getToken())
        }
        val request = CompletionRequest(
            model = GigaChatModel.GIGA_CHAT,
            messages = listOf(
                Message(GigaChatRole.ROLE_USER, content)
            ),
            temperature = 0.4
        )
        val requestEntity = HttpEntity(request, headers)
        val response = restTemplate.exchange(
            COMPLETIONS_URL,
            HttpMethod.POST,
            requestEntity,
            GigaChatResponse::class.java
        )
        return CommonGenerativeContentResponse(response.body!!.choices[0].message.content)
    }
}