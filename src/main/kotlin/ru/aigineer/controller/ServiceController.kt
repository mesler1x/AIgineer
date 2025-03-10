package ru.aigineer.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.aigineer.model.dto.response.ServiceResponse
import ru.aigineer.model.dto.response.ToneResponse
import ru.aigineer.service.LlmService

@RestController
@RequestMapping("/service")
class ServiceController(
    private val llmService: LlmService
) {

    @GetMapping("/findAll")
    fun findAll(): List<ServiceResponse> {
        return llmService.findAll()
    }
}