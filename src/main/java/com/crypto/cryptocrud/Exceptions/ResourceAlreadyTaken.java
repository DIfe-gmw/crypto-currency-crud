package com.crypto.cryptocrud.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.IM_USED)
public class ResourceAlreadyTaken extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceAlreadyTaken(String message) {
        super(message);
    }
}
