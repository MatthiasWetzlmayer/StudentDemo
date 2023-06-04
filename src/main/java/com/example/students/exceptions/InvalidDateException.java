package com.example.students.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InvalidDateException extends BadRequestException{

    public InvalidDateException(){}
    public InvalidDateException(String message) {
        super(message);
    }
}
