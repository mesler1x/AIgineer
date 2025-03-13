package ru.aigineer.controller

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.aigineer.model.dto.response.StyleResponse
import ru.aigineer.service.StyleService

@RestController
@RequestMapping("/style")
@CrossOrigin(origins = ["http://localhost:5173", "*"])
class StyleController(
    private val styleService: StyleService
) {

    @GetMapping("/findAll")
    fun findAll(): List<StyleResponse> {
        return styleService.findAll()
    }
}