package ru.aigineer.service

import org.springframework.stereotype.Service
import ru.aigineer.controller.exception.NotFoundException
import ru.aigineer.dao.CelebrationDao
import ru.aigineer.dao.ServiceDao
import ru.aigineer.model.dto.response.CelebrationResponse
import ru.aigineer.model.dto.response.ServiceResponse
import java.util.*

@Service
class CelebrationService(
    private val celebrationDao: CelebrationDao,
) {
    fun findAll(): List<CelebrationResponse> {
        return celebrationDao.findAll()
    }

    fun findById(id: UUID): CelebrationResponse {
        return celebrationDao.findById(id) ?: throw NotFoundException("Celebration with id [$id] was not found")
    }
}