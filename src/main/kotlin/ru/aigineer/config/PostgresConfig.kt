package ru.aigineer.config

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
class PostgresConfig {

    @Value("\${datasource.url}")
    private lateinit var url: String

    @Value("\${datasource.username}")
    private lateinit var username: String

    @Value("\${datasource.password}")
    private lateinit var password: String


    @Bean
    fun dataSource(): DataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName("org.postgresql.Driver")
        dataSource.url = url
        dataSource.username = username
        dataSource.password = password
        return dataSource
    }

    @Bean
    fun sqlSessionFactory(dataSource: DataSource): SqlSessionFactory {
        val sqlSessionFactoryBean = SqlSessionFactoryBean()
        sqlSessionFactoryBean.setDataSource(dataSource)
        val resolver = PathMatchingResourcePatternResolver()
        val resources = resolver.getResources("classpath:mappers/*.xml")
        sqlSessionFactoryBean.setMapperLocations(*resources)
        return sqlSessionFactoryBean.getObject()!!
    }
}