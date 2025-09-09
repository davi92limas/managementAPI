package com.usermanagement.api.repository;

import com.usermanagement.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for User entity.
 * 
 * Provides data access methods for system users
 * including queries by email, phone, and CPF.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find user by email
     */
    Optional<User> findByEmail(String email);

    /**
     * Find user by phone
     */
    Optional<User> findByPhone(String phone);

    /**
     * Find user by CPF
     */
    Optional<User> findByCpf(String cpf);

    /**
     * Check if user exists by email
     */
    boolean existsByEmail(String email);

    /**
     * Check if user exists by phone
     */
    boolean existsByPhone(String phone);

    /**
     * Check if user exists by CPF
     */
    boolean existsByCpf(String cpf);
}
