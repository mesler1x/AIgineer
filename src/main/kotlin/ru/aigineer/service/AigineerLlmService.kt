package ru.aigineer.service

import org.springframework.stereotype.Service
import ru.aigineer.controller.exception.NotFoundException
import ru.aigineer.dao.ServiceDao
import ru.aigineer.model.dto.response.ServiceResponse
import java.util.*

@Service
class AigineerLlmService(
    private val serviceDao: ServiceDao,
) {
    fun findAll(): List<ServiceResponse> {
        return serviceDao.findAll()
    }

    fun findById(id: UUID): ServiceResponse {
        return serviceDao.findById(id) ?: throw NotFoundException("Service with id [$id] was not found")
    }
}