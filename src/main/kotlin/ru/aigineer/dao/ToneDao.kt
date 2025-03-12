package ru.aigineer.dao

import org.springframework.stereotype.Repository
import ru.aigineer.dao.mappers.ToneMapper
import ru.aigineer.model.dto.response.ToneResponse
import java.util.*

@Repository
class ToneDao(
    private val mapper: ToneMapper
) {
    fun findAll(): List<ToneResponse> {
        return mapper.findAll()
    }

    fun findById(id: UUID): ToneResponse? {
        return mapper.findById(id)
    }
}