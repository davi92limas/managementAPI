package com.usermanagement.api.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Standardized error response structure for the User Management API.
 * 
 * Provides consistent error information across all API endpoints
 * including timestamp, status code, error type, message, and optional details.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    /**
     * Timestamp when the error occurred
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime timestamp;

    /**
     * HTTP status code
     */
    private int status;

    /**
     * Error type/category
     */
    private String error;

    /**
     * Human-readable error message
     */
    private String message;

    /**
     * Request path where the error occurred
     */
    private String path;

    /**
     * Additional error details (e.g., field validation errors)
     */
    private Map<String, String> details;

    /**
     * Error code for programmatic handling
     */
    private String errorCode;

    /**
     * Additional context information
     */
    private Object context;
}
