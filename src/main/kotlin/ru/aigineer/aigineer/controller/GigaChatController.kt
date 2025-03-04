package ru.aigineer.aigineer.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.aigineer.aigineer.service.GigaChatService

@RestController
class GigaChatController(
    private val gigaChatService: GigaChatService
) {
    @PostMapping("/send")
    fun sendMessage(@RequestBody message: String) : String {
        return gigaChatService.sendMessage(message)
    }
}