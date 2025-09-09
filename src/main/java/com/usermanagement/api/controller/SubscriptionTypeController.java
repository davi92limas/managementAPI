package com.usermanagement.api.controller;

import com.usermanagement.api.model.SubscriptionType;
import com.usermanagement.api.service.SubscriptionTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for SubscriptionType entity operations.
 * 
 * Provides CRUD endpoints for subscription type management with
 * role-based access control using Spring Security.
 */
@RestController
@RequestMapping("/subscription-types")
@RequiredArgsConstructor
@Slf4j
public class SubscriptionTypeController {

    private final SubscriptionTypeService subscriptionTypeService;

    /**
     * Get all subscription types
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<List<SubscriptionType>> findAll() {
        log.info("Request to get all subscription types");
        List<SubscriptionType> subscriptionTypes = subscriptionTypeService.findAll();
        return ResponseEntity.ok(subscriptionTypes);
    }

    /**
     * Get subscription type by ID
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<SubscriptionType> findById(@PathVariable Long id) {
        log.info("Request to get subscription type by ID: {}", id);
        Optional<SubscriptionType> subscriptionType = subscriptionTypeService.findById(id);
        return subscriptionType.map(ResponseEntity::ok)
                              .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get subscription type by product key
     */
    @GetMapping("/product-key/{productKey}")
    @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<SubscriptionType> findByProductKey(@PathVariable String productKey) {
        log.info("Request to get subscription type by product key: {}", productKey);
        Optional<SubscriptionType> subscriptionType = subscriptionTypeService.findByProductKey(productKey);
        return subscriptionType.map(ResponseEntity::ok)
                              .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Create new subscription type
     */
    @PostMapping
    @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<SubscriptionType> create(@RequestBody SubscriptionType subscriptionType) {
        log.info("Request to create new subscription type: {}", subscriptionType.getName());
        SubscriptionType savedSubscriptionType = subscriptionTypeService.save(subscriptionType);
        return ResponseEntity.ok(savedSubscriptionType);
    }

    /**
     * Update existing subscription type
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<SubscriptionType> update(@PathVariable Long id, @RequestBody SubscriptionType subscriptionType) {
        log.info("Request to update subscription type with ID: {}", id);
        
        Optional<SubscriptionType> existingSubscriptionType = subscriptionTypeService.findById(id);
        if (existingSubscriptionType.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        subscriptionType.setId(id);
        SubscriptionType updatedSubscriptionType = subscriptionTypeService.save(subscriptionType);
        return ResponseEntity.ok(updatedSubscriptionType);
    }

    /**
     * Delete subscription type by ID
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        log.info("Request to delete subscription type with ID: {}", id);
        
        Optional<SubscriptionType> existingSubscriptionType = subscriptionTypeService.findById(id);
        if (existingSubscriptionType.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        
        subscriptionTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
