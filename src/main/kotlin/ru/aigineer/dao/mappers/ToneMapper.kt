package ru.aigineer.dao.mappers

import org.apache.ibatis.annotations.Mapper
import ru.aigineer.model.dto.response.ToneResponse

@Mapper
interface ToneMapper {
    fun findAll(): List<ToneResponse>
}