package com.example.heardit_songmanager_service.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundSongEntryException extends ResponseStatusException {
    public NotFoundSongEntryException(String errorCode) {
        super(HttpStatus.BAD_REQUEST, errorCode);
    }
}
