package com.example.heardit.service.exceptions;
import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Generated
public class NotFoundSongException extends ResponseStatusException {
    public NotFoundSongException(String errorCode) {
        super(HttpStatus.BAD_REQUEST, errorCode);
    }
}
