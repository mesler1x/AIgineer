package ru.aigineer.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.aigineer.model.dto.response.ToneResponse
import ru.aigineer.service.ToneService

@RestController
@RequestMapping("/tone")
class ToneController(
    private val toneService: ToneService
) {
    @GetMapping("/findAll")
    fun findAll(): List<ToneResponse> {
        return toneService.findAll()
    }
}