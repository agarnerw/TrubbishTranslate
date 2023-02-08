package com.agarnerw.trubbishtranslate;

import com.agarnerw.trubbishtranslate.domain.BadRequestException;
import com.agarnerw.trubbishtranslate.domain.ExceptionResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class APIErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequest(BadRequestException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse("400",
                "badRequestException",
                exception.getMessage());
        return ResponseEntity.status(400).contentType(MediaType.APPLICATION_PROBLEM_JSON).body(exceptionResponse);
    }
}
