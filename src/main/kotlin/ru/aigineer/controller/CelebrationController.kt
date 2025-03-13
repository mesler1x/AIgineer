package ru.aigineer.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.aigineer.model.dto.response.CelebrationResponse
import ru.aigineer.service.CelebrationService

@RestController
@RequestMapping("/celebration")
@CrossOrigin(origins = ["http://localhost:5173", "*"])
class CelebrationController(
    private val celebrationService: CelebrationService
) {
    @GetMapping("/findAll")
    fun findAll(): List<CelebrationResponse> {
        return celebrationService.findAll()
    }
}