package ru.aigineer.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.aigineer.model.dto.request.PromptRequest
import ru.aigineer.model.dto.response.PromptResponse
import ru.aigineer.service.GigaChatService

@RestController
@RequestMapping("/prompt")
class GigaChatController(
    private val gigaChatService: GigaChatService
) {


    @PostMapping("/send")
    fun sendMessage(@RequestBody promptRequest: PromptRequest): PromptResponse {
        return gigaChatService.sendMessage(promptRequest)
    }
}