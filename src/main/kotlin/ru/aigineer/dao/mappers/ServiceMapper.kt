package ru.aigineer.dao.mappers

import org.apache.ibatis.annotations.Mapper
import ru.aigineer.model.dto.response.ServiceResponse

@Mapper
interface ServiceMapper {
    fun findAll(): List<ServiceResponse>
}