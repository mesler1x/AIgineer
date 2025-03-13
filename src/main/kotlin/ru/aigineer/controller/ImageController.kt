package ru.aigineer.controller

import io.swagger.v3.oas.annotations.Operation
import org.apache.commons.io.IOUtils
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.InputStream
import java.net.URI


@RestController
@RequestMapping("/image")
class ImageController {

    @GetMapping
    @Operation(summary = "Получить изображение")
    fun getImage(): ResponseEntity<ByteArray> {
        val url = "https://kormvmeshke.ru/upload/medialibrary/8da/8dacdbb8ee670403751ad1e8ff285385.jpg"
        val inputStream: InputStream = URI(url).toURL().openStream()


        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_JPEG)
            .body(IOUtils.toByteArray(inputStream))
    }
}