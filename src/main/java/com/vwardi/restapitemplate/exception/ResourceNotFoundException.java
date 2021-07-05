package com.vwardi.restapitemplate.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, String resourceId) {
        super(resourceName + " was not found for ID: " + resourceId);
    }
}