package com.rishbootdev.bloomway.exceptions;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
@RequiredArgsConstructor
public class BadRequestException extends RuntimeException{
    private final String message;
}
