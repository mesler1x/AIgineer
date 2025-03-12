package ru.aigineer.dao.mappers

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import ru.aigineer.model.dto.response.PromptResponse
import java.util.UUID

@Mapper
interface PromptMapper {
    fun findAll(): List<PromptResponse>

    fun findById(@Param("id") id: UUID): PromptResponse?

    fun findByServiceId(@Param("serviceId") serviceId: UUID): PromptResponse?
}