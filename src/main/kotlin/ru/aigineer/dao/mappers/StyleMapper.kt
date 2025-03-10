package ru.aigineer.dao.mappers

import org.apache.ibatis.annotations.Mapper
import ru.aigineer.model.dto.response.CelebrationResponse
import ru.aigineer.model.dto.response.StyleResponse

@Mapper
interface StyleMapper {
    fun findAll(): List<StyleResponse>
}