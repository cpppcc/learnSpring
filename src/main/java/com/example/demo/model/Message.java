package com.example.demo.model;

public class Message {
    boolean hasError;
    String message;

    public Message(boolean hasError, String message) {
        this.hasError = hasError;
        this.message = message;
    }

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
