package ru.aigineer.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/prompt")
class GigaChatController(
    private val gigaChatService: ru.aigineer.service.GigaChatService
) {


    @PostMapping("/send")
    fun sendMessage(@RequestBody promptRequest: ru.aigineer.model.dto.request.PromptRequest): ru.aigineer.model.dto.response.PromptResponse {
        return gigaChatService.sendMessage(promptRequest)
    }
}