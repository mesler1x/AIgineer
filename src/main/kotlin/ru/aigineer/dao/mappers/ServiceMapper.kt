package ru.aigineer.dao.mappers

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import ru.aigineer.model.dto.response.ServiceResponse
import java.util.*

@Mapper
interface ServiceMapper {
    fun findAll(): List<ServiceResponse>
    fun findById(@Param("id") id: UUID): ServiceResponse?
}