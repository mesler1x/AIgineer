package ru.aigineer.dao.mappers

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import ru.aigineer.model.dto.response.CelebrationResponse
import java.util.*

@Mapper
interface CelebrationMapper {
    fun findAll(): List<CelebrationResponse>
    fun findById(@Param("id") id: UUID): CelebrationResponse?
}