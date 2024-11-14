package com.kartik.app.PayLoad;

import org.springframework.http.HttpStatus;

public class ApiResponse {

    private String message;
    private boolean success;
    private HttpStatus status;

    // Default constructor
    public ApiResponse() {
    }

    // Constructor with parameters
    public ApiResponse(String message, boolean success, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.status = status;
    }

    // Getter for message
    public String getMessage() {
        return message;
    }

    // Setter for message
    public void setMessage(String message) {
        this.message = message;
    }

    // Getter for success
    public boolean isSuccess() {
        return success;
    }

    // Setter for success
    public void setSuccess(boolean success) {
        this.success = success;
    }

    // Getter for status
    public HttpStatus getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
