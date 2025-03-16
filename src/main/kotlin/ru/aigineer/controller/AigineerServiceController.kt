package ru.aigineer.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.aigineer.model.dto.response.ServiceResponse
import ru.aigineer.service.AigineerLlmService

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = ["http://localhost:5173", "*"])
class AigineerServiceController(
    private val aigineerLlmService: AigineerLlmService
) {

    @GetMapping("/findAll")
    fun findAll(): List<ServiceResponse> {
        return aigineerLlmService.findAll()
    }
}