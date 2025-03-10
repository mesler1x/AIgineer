package ru.aigineer.dao

import org.springframework.stereotype.Repository
import ru.aigineer.dao.mappers.CelebrationMapper
import ru.aigineer.model.dto.response.CelebrationResponse

@Repository
class CelebrationDao(
    private val mapper: CelebrationMapper,
) {
    fun findAll(): List<CelebrationResponse> {
        return mapper.findAll()
    }
}