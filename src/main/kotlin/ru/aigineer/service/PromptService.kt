package ru.aigineer.service

import org.springframework.stereotype.Service
import ru.aigineer.controller.exception.NotFoundException
import ru.aigineer.dao.PromptDao
import ru.aigineer.model.dto.response.CelebrationResponse
import ru.aigineer.model.dto.response.PromptResponse
import java.util.*

@Service
class PromptService(
    private val promptDao: PromptDao,
) {
    fun findAll(): List<PromptResponse> {
        return promptDao.findAll()
    }

    fun findById(id: UUID): PromptResponse {
        return promptDao.findById(id) ?: throw NotFoundException("Prompt with id [$id] was not found")
    }

    fun findByServiceId(serviceId: UUID): PromptResponse {
        return promptDao.findByServiceId(serviceId) ?: throw NotFoundException("Prompt with service id [$serviceId] was not found")
    }
}