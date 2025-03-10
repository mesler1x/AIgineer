package ru.aigineer.service

import org.springframework.stereotype.Service
import ru.aigineer.dao.StyleDao
import ru.aigineer.model.dto.response.StyleResponse

@Service
class StyleService(
    private val styleDao: StyleDao
) {
    fun findAll(): List<StyleResponse> {
        return styleDao.findAll()
    }
}