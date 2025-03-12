package ru.aigineer.controller

import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.aigineer.model.dto.request.PromptRequest
import ru.aigineer.model.dto.response.CommonGenerativeContentResponse
import ru.aigineer.model.dto.response.PromptResponse
import ru.aigineer.service.GigaChatService

@RestController
@RequestMapping("/prompt", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
class GigaChatController(
    private val gigaChatService: GigaChatService
) {


    @Operation(summary = "Отправка сообщения на генерацию текста")
    @PostMapping("/send")
    fun sendMessage(@Valid @RequestBody promptRequest: PromptRequest): CommonGenerativeContentResponse {
        return gigaChatService.sendMessage(promptRequest)
    }
}