package com.ashokit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handleException(Exception e){
        return new ResponseEntity<>("Some Problem", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = TicketNotFoundException.class)
    public ResponseEntity<ExceptionInfo> handleBusinessException(TicketNotFoundException ticketNotFoundException){
        ExceptionInfo exceptionInfo=new ExceptionInfo();
        exceptionInfo.setExceptionCode("EX00001");
        exceptionInfo.setExceptionDescription(ticketNotFoundException.getMessage());
        exceptionInfo.setExceptionLocalDateTime(LocalDateTime.now());

        return new ResponseEntity<>(exceptionInfo,HttpStatus.BAD_REQUEST);
    }



}
