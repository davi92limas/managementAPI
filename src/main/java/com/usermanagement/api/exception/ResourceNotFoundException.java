package com.usermanagement.api.exception;

/**
 * Exception thrown when a requested resource is not found.
 * 
 * This exception is typically used in service layers when
 * attempting to retrieve entities that don't exist in the database.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructs a new ResourceNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new ResourceNotFoundException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a ResourceNotFoundException for a specific resource type and ID.
     *
     * @param resourceType the type of resource (e.g., "User", "SubscriptionType")
     * @param id the ID of the resource
     */
    public ResourceNotFoundException(String resourceType, Object id) {
        super(String.format("%s not found with id: %s", resourceType, id));
    }

    /**
     * Constructs a ResourceNotFoundException for a specific resource type and field.
     *
     * @param resourceType the type of resource (e.g., "User", "SubscriptionType")
     * @param fieldName the name of the field used for lookup
     * @param fieldValue the value of the field
     */
    public ResourceNotFoundException(String resourceType, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s: %s", resourceType, fieldName, fieldValue));
    }
}
