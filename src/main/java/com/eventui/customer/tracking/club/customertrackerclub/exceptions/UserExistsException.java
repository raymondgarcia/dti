package com.eventui.customer.tracking.club.customertrackerclub.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserExistsException extends ValidationException {
    public UserExistsException(final String message) {
        super(message);
    }
}
