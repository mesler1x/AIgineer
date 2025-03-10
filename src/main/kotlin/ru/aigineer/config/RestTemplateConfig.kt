package ru.aigineer.config

import org.apache.hc.client5.http.impl.classic.HttpClients
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder
import org.apache.hc.client5.http.io.HttpClientConnectionManager
import org.apache.hc.client5.http.ssl.DefaultClientTlsStrategy
import org.apache.hc.core5.ssl.SSLContexts
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

const val GIGA_CHAT_REST_TEMPLATE_BEAN_NAME = "gigaChatRestTemplate"

@Configuration
class RestTemplateConfig {

    @Bean(GIGA_CHAT_REST_TEMPLATE_BEAN_NAME)
    fun restTemplate(): RestTemplate = RestTemplate(getRequestFactory())

    fun getRequestFactory(): ClientHttpRequestFactory {
        val sslContext = SSLContexts.custom()
            .loadTrustMaterial { _, _ -> true }
            .build()

        val tlsStrategy = DefaultClientTlsStrategy(sslContext)
        val connectionManager: HttpClientConnectionManager = PoolingHttpClientConnectionManagerBuilder
            .create()
            .setTlsSocketStrategy(tlsStrategy)
            .build()

        val hc = HttpClients.custom()
            .setConnectionManager(connectionManager)
            .build()

        return HttpComponentsClientHttpRequestFactory(hc)
    }
}