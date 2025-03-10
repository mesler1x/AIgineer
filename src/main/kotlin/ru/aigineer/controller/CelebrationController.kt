package ru.aigineer.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.aigineer.model.dto.response.CelebrationResponse

@RestController
@RequestMapping("/celebration")
class CelebrationController {
    @GetMapping("/findAll")
    fun findAll(): List<CelebrationResponse> {
        return listOf()
    }
}