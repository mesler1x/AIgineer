package ru.aigineer.service

import org.springframework.stereotype.Service
import ru.aigineer.controller.exception.NotFoundException
import ru.aigineer.dao.ToneDao
import ru.aigineer.model.dto.response.ToneResponse
import java.util.UUID

@Service
class ToneService(
    private val toneDao: ToneDao,
) {
    fun findAll(): List<ToneResponse> {
        return toneDao.findAll()
    }

    fun findById(id: UUID): ToneResponse {
        return toneDao.findById(id) ?: throw NotFoundException("Tone with id [$id] was not found")
    }
}