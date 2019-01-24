package com.eventui.customer.tracking.club.customertrackerclub.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RevertConfigException extends RuntimeException {

    public RevertConfigException(final String msg) {
        super(msg);
    }

}
