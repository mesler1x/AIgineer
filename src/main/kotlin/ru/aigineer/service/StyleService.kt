package ru.aigineer.service

import org.springframework.stereotype.Service
import ru.aigineer.controller.exception.NotFoundException
import ru.aigineer.dao.StyleDao
import ru.aigineer.model.dto.response.StyleResponse
import java.util.UUID

@Service
class StyleService(
    private val styleDao: StyleDao
) {
    fun findAll(): List<StyleResponse> {
        return styleDao.findAll()
    }

    fun findById(id: UUID): StyleResponse {
        return styleDao.findById(id) ?: throw NotFoundException("Style with id [$id] was not found")
    }
}