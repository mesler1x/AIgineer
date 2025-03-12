package ru.aigineer.dao

import org.springframework.stereotype.Repository
import ru.aigineer.dao.mappers.StyleMapper
import ru.aigineer.model.dto.response.StyleResponse
import java.util.*

@Repository
class StyleDao(
    private val mapper: StyleMapper
) {
    fun findAll(): List<StyleResponse> {
        return mapper.findAll()
    }

    fun findById(id: UUID): StyleResponse? {
        return mapper.findById(id)
    }
}