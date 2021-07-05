package com.vwardi.restapitemplate.exception;

import java.time.LocalDateTime;
import java.util.UUID;

public class ErrorMessage {

    private final int statusCode;
    private final LocalDateTime timestamp;
    private final String message;
    private final UUID traceId;

    private ErrorMessage(int statusCode, LocalDateTime timestamp, String message) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
        this.traceId = UUID.randomUUID();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public UUID getTraceId() {
        return traceId;
    }

    public static ErrorMessageBuilder builder() {
        return new ErrorMessageBuilder();
    }

    public static class ErrorMessageBuilder {

        private int statusCode;
        private LocalDateTime timestamp;
        private String message;

        public ErrorMessageBuilder withStatusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public ErrorMessageBuilder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorMessageBuilder withActualTimestamp() {
            this.timestamp = LocalDateTime.now();
            return this;
        }

        public ErrorMessageBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ErrorMessage build() {
            return new ErrorMessage(statusCode, timestamp, message);
        }
    }
}


