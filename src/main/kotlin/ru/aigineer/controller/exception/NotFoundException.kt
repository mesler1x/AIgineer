package ru.aigineer.controller.exception

class NotFoundException(override val message: String): RuntimeException(message)