package com.bookmyshow.api.exceptions;

import com.bookmyshow.api.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex)
    {
        String message= ex.getMessage();
        ApiResponse response=new ApiResponse(message,false);

        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND );
    }

}
