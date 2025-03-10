package ru.aigineer.service

import org.springframework.stereotype.Service
import ru.aigineer.dao.ServiceDao
import ru.aigineer.model.dto.response.ServiceResponse

@Service
class LlmService(
    private val serviceDao: ServiceDao,
) {
    fun findAll(): List<ServiceResponse> {
        return serviceDao.findAll()
    }
}