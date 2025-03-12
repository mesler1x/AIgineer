package ru.aigineer.dao.mappers

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import ru.aigineer.model.dto.response.CelebrationResponse
import ru.aigineer.model.dto.response.StyleResponse
import java.util.*

@Mapper
interface StyleMapper {
    fun findAll(): List<StyleResponse>
    fun findById(@Param("id") id: UUID): StyleResponse?
}