package com.jaju.where2skate.security.exception

import com.fasterxml.jackson.databind.ObjectMapper
import com.jaju.where2skate.util.error.ErrorMsg
import org.apache.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class SecurityExceptionHandler : AuthenticationEntryPoint, AccessDeniedHandler {

    fun handleEx(req: HttpServletRequest, resp: HttpServletResponse, ex: RuntimeException) {
        resp.status=HttpStatus.SC_FORBIDDEN
        resp.contentType= MediaType.APPLICATION_JSON_VALUE
        resp.outputStream.write(ObjectMapper().writeValueAsBytes( when (ex) {
            is AccessDeniedException -> ErrorMsg(HttpStatus.SC_FORBIDDEN,ex.localizedMessage,"You are not a moderator")
            is AuthenticationException -> ErrorMsg(HttpStatus.SC_FORBIDDEN,ex.localizedMessage,"Wrong token")
            else -> ErrorMsg(HttpStatus.SC_FORBIDDEN,ex.localizedMessage,ex.message)
        }))
    }

    override fun handle(req: HttpServletRequest, resp: HttpServletResponse, ex: AccessDeniedException) {
        handleEx(req,resp, ex)
    }

    override fun commence(req: HttpServletRequest, resp: HttpServletResponse,  ex: AuthenticationException) {
        handleEx(req,resp, ex)
    }
}