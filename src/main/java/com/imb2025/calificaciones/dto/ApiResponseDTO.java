package com.imb2025.calificaciones.dto;

import java.time.Instant;

public class ApiResponseDTO<T> {
    private boolean success;
    private T data;
    private String message;
    private Instant timestamp;

    public ApiResponseDTO() {
        this.timestamp = Instant.now();
    }

    public ApiResponseDTO(boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
        this.timestamp = Instant.now();
    }

    // Getters y setters

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}