package ru.aigineer.dao

import org.springframework.stereotype.Repository
import ru.aigineer.dao.mappers.ToneMapper
import ru.aigineer.model.dto.response.ToneResponse

@Repository
class ToneDao(
    private val mapper: ToneMapper
) {
    fun findAll(): List<ToneResponse> {
        return mapper.findAll()
    }
}