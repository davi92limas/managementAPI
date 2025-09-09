package com.usermanagement.api.repository;

import com.usermanagement.api.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for UserType entity.
 */
@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {

    /**
     * Find user type by name
     */
    Optional<UserType> findByName(String name);

    /**
     * Check if user type exists by name
     */
    boolean existsByName(String name);
}
