package ru.aigineer.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.aigineer.model.dto.response.ToneResponse

@RestController
@RequestMapping("/tone")
class ToneController {
    @GetMapping("/findAll")
    fun findAll(): List<ToneResponse> {
        return listOf()
    }
}