package ru.aigineer.service

import org.springframework.stereotype.Service
import ru.aigineer.dao.CelebrationDao
import ru.aigineer.dao.ServiceDao
import ru.aigineer.model.dto.response.CelebrationResponse
import ru.aigineer.model.dto.response.ServiceResponse

@Service
class CelebrationService(
    private val celebrationDao: CelebrationDao,
) {
    fun findAll(): List<CelebrationResponse> {
        return celebrationDao.findAll()
    }
}