package com.usermanagement.api.repository;

import com.usermanagement.api.model.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for SubscriptionType entity.
 */
@Repository
public interface SubscriptionTypeRepository extends JpaRepository<SubscriptionType, Long> {

    /**
     * Find subscription type by product key
     */
    Optional<SubscriptionType> findByProductKey(String productKey);

    /**
     * Find subscription type by name
     */
    Optional<SubscriptionType> findByName(String name);

    /**
     * Check if subscription type exists by product key
     */
    boolean existsByProductKey(String productKey);

    /**
     * Check if subscription type exists by name
     */
    boolean existsByName(String name);
}
