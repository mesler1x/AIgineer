package ru.aigineer.controller

import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import ru.aigineer.model.dto.request.PromptRequest
import ru.aigineer.model.dto.response.CommonGenerativeContentResponse
import ru.aigineer.model.dto.response.PromptResponse
import ru.aigineer.service.GigaChatService

@RestController
@CrossOrigin(origins = ["http://localhost:5173", "*"])
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