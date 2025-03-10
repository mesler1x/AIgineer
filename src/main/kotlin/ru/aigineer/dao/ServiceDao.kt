package ru.aigineer.dao

import org.springframework.stereotype.Repository
import ru.aigineer.dao.mappers.ServiceMapper
import ru.aigineer.model.dto.response.CelebrationResponse
import ru.aigineer.model.dto.response.ServiceResponse

@Repository
class ServiceDao(
    private val mapper: ServiceMapper
) {
    fun findAll(): List<ServiceResponse> {
        return mapper.findAll()
    }
}