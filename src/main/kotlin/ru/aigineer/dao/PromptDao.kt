package ru.aigineer.dao

import org.springframework.stereotype.Repository
import ru.aigineer.dao.mappers.PromptMapper
import ru.aigineer.model.dto.response.PromptResponse
import java.util.*

@Repository
class PromptDao(
    private val mapper: PromptMapper,
) {

    fun findAll(): List<PromptResponse> {
        return mapper.findAll()
    }

    fun findById(id: UUID): PromptResponse? {
        return mapper.findById(id)
    }

    fun findByServiceId(serviceId: UUID): PromptResponse? {
        return mapper.findByServiceId(serviceId)
    }
}