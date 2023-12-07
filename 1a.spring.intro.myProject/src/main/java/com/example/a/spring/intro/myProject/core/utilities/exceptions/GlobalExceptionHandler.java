package com.example.a.spring.intro.myProject.core.utilities.exceptions;

import com.example.a.spring.intro.myProject.services.dtos.car.requests.AddCarRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationError(MethodArgumentNotValidException exception){

            return exception.getBindingResult().getAllErrors().stream()
                    .map(error -> error instanceof FieldError
                            ? "Field '" + ((FieldError) error).getField() + "': " + error.getDefaultMessage()
                            : error.getDefaultMessage())
                    .collect(Collectors.joining(", "));

    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleRuntimeException(RuntimeException exception){
        return exception.getMessage();
    }
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleError(Exception exception)
    {
        return exception.getMessage();
    }
}

