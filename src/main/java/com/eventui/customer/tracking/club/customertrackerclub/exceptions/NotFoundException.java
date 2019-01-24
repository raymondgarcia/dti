package com.eventui.customer.tracking.club.customertrackerclub.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(final String fieldNotFoundName) {
        super(buildErrorMessage(fieldNotFoundName));
    }

    public NotFoundException(final String objectToFindName, final String propertyName) {
        super(buildErrorMessage(objectToFindName, propertyName));
    }

    public NotFoundException(final String objectToFindName, final String propertyName, final String propertyValue) {
        super(buildErrorMessage(objectToFindName, propertyName, propertyValue));
    }

    private static String buildErrorMessage(final String fieldNotFoundName) {
        return MessageFormat.format("{0} was not found.", fieldNotFoundName);
    }

    private static String buildErrorMessage(final String objectToFindName, final String propertyName) {
        return MessageFormat.format("{0} with {1} was not found.", objectToFindName, propertyName);
    }

    private static String buildErrorMessage(final String objectToFindName, final String propertyName,
        final String propertyValue) {
        return MessageFormat.format("{0} with {1}: {2} was not found.", objectToFindName, propertyName, propertyValue);
    }
}
