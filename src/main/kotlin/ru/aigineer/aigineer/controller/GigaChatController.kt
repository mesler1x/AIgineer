package ru.aigineer.aigineer.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.aigineer.aigineer.model.dto.PromptRequest
import ru.aigineer.aigineer.model.dto.PromptResponse
import ru.aigineer.aigineer.service.GigaChatService

@RestController
@RequestMapping("/prompt")
class GigaChatController(
    private val gigaChatService: GigaChatService
) {


    @PostMapping("/send")
    fun sendMessage(@RequestBody promptRequest: PromptRequest) : PromptResponse {
        return gigaChatService.sendMessage(promptRequest)
    }
}