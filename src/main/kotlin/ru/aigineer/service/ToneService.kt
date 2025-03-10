package ru.aigineer.service

import org.springframework.stereotype.Service
import ru.aigineer.dao.ToneDao
import ru.aigineer.model.dto.response.ToneResponse

@Service
class ToneService(
    private val toneDao: ToneDao,
) {
    fun findAll(): List<ToneResponse> {
        return toneDao.findAll()
    }
}