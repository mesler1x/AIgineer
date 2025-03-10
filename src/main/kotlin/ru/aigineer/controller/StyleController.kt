package ru.aigineer.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.aigineer.model.dto.response.StyleResponse

@RestController
@RequestMapping("/style")
class StyleController {

    @GetMapping("/findAll")
    fun findAll(): List<StyleResponse> {
        return listOf()
    }
}