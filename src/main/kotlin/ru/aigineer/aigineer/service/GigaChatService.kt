package ru.aigineer.aigineer.service

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.aigineer.aigineer.config.GIGA_CHAT_REST_TEMPLATE_BEAN_NAME
import java.lang.reflect.Array.set
import java.util.UUID

@Service
class GigaChatService(
    @Qualifier(GIGA_CHAT_REST_TEMPLATE_BEAN_NAME)
    private val restTemplate: RestTemplate,
) {

    @Value("\${gigachat.auth-key}")
    private val authKey: String? = null

    fun sendMessage(message: String) : String {
        val url = "https://ngw.devices.sberbank.ru:9443/api/v2/oauth"
        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_FORM_URLENCODED
            set("Accept", "application/json")
            set("RqUID", UUID.randomUUID().toString())
            set("Authorization", "Basic $authKey")
        }

        val body = "scope=GIGACHAT_API_PERS"
        val requestEntity = HttpEntity(body, headers)
        val response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String::class.java)
        return "${response.body}"
    }

    fun getToken(): String {

    }
}