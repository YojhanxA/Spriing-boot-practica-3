package com.yojhan.curso.springboot.error.springboot_error.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.yojhan.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.yojhan.curso.springboot.error.springboot_error.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionByzero(Exception ex) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error division por cero");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception ex) {
        Map<String, Object> errorN = new HashMap<>();// con map no es necesario crear clase dto
        errorN.put("Date", new Date());
        errorN.put("Error", "Numero erroneo");
        errorN.put("Message", ex.getMessage());
        errorN.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return errorN;
    }

    @ExceptionHandler({ NullPointerException.class,
            HttpMessageNotWritableException.class,
            UserNotFoundException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundException(Exception ex) {
        Map<String, Object> errorN = new HashMap<>();// con map no es necesario crear clase dto
        errorN.put("Date", new Date());
        errorN.put("Error", "El usuario o rol no existe");
        errorN.put("Message", ex.getMessage());
        errorN.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return errorN;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFound(NoHandlerFoundException e) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Api rest no encontrada");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);

    }
}
