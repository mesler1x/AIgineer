package ru.aigineer.dao.mappers

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import ru.aigineer.model.dto.response.ToneResponse
import java.util.*

@Mapper
interface ToneMapper {
    fun findAll(): List<ToneResponse>
    fun findById(@Param("id") id: UUID): ToneResponse?
}