package com.example.demo.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
@Data
@RequiredArgsConstructor
public class ApiException extends RuntimeException{
    private final HttpStatus status;
    private final String message;
}
