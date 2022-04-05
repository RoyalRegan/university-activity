package ru.jaju.financemanagerserver.exception;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity handleValidationException(ValidationException ex) {
        return new ResponseEntity<>(Collections.singletonMap("message", ex.getListOfMsg()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoginAlreadyTakenException.class)
    protected ResponseEntity handleLoginAlreadyTakenException(LoginAlreadyTakenException ex) {
        return new ResponseEntity<>(Collections.singletonMap("message", ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    protected ResponseEntity handleIncorrectPassword(IncorrectPasswordException ex) {
        return new ResponseEntity<>(Collections.singletonMap("message", ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({WrongJsonException.class, AbstractNotFoundException.class})
    protected ResponseEntity handleWrongJsonException(WrongJsonException ex) {
        if (Strings.isNotBlank(ex.getMessage())) {
            return new ResponseEntity<>(Collections.singletonMap("message", ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JWTVerificationException.class)
    protected ResponseEntity handleJWTVerificationException() {
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}