package com.jaju.kursach_core.web

import com.fasterxml.jackson.databind.ObjectMapper
import com.jaju.kursach_core.security.DuplicateLoginException
import io.netty.handler.codec.http.HttpResponseStatus.CONFLICT
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class ExceptionController {

    @ExceptionHandler(DuplicateLoginException::class)
    fun duplicateLoginExceptionHandler(duplicateLoginException: DuplicateLoginException,response: HttpServletResponse) {
        response.status = CONFLICT.code()
        ObjectMapper().writeValue(response.outputStream,mapOf("message" to duplicateLoginException.message!!))
    }
}