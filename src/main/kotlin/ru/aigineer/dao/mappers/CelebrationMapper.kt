package ru.aigineer.dao.mappers

import org.apache.ibatis.annotations.Mapper
import ru.aigineer.model.dto.response.CelebrationResponse

@Mapper
interface CelebrationMapper {
    fun findAll(): List<CelebrationResponse>
}