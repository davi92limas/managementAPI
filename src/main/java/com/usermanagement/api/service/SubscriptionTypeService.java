package com.usermanagement.api.service;

import com.usermanagement.api.model.SubscriptionType;
import com.usermanagement.api.repository.SubscriptionTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service class for SubscriptionType entity operations.
 * 
 * Provides business logic for subscription type management
 * including CRUD operations and validation methods.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionTypeService {

    private final SubscriptionTypeRepository subscriptionTypeRepository;

    @Transactional(readOnly = true)
    public List<SubscriptionType> findAll() {
        log.debug("Finding all subscription types");
        return subscriptionTypeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<SubscriptionType> findById(Long id) {
        log.debug("Finding subscription type by ID: {}", id);
        return subscriptionTypeRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<SubscriptionType> findByProductKey(String productKey) {
        log.debug("Finding subscription type by product key: {}", productKey);
        return subscriptionTypeRepository.findByProductKey(productKey);
    }

    @Transactional(readOnly = true)
    public Optional<SubscriptionType> findByName(String name) {
        log.debug("Finding subscription type by name: {}", name);
        return subscriptionTypeRepository.findByName(name);
    }

    @Transactional
    public SubscriptionType save(SubscriptionType subscriptionType) {
        log.info("Saving subscription type: {}", subscriptionType.getName());
        return subscriptionTypeRepository.save(subscriptionType);
    }

    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting subscription type with ID: {}", id);
        subscriptionTypeRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public boolean existsByProductKey(String productKey) {
        return subscriptionTypeRepository.existsByProductKey(productKey);
    }

    @Transactional(readOnly = true)
    public boolean existsByName(String name) {
        return subscriptionTypeRepository.existsByName(name);
    }
}
