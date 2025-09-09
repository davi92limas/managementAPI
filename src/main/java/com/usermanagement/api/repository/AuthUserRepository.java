package com.usermanagement.api.repository;

import com.usermanagement.api.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for AuthUser entity.
 * 
 * Provides data access methods for authentication users
 * including queries by username, email, and role.
 */
@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

    /**
     * Find user by username
     */
    Optional<AuthUser> findByUsername(String username);

    /**
     * Find user by email
     */
    Optional<AuthUser> findByEmail(String email);

    /**
     * Find user by username or email
     */
    @Query("SELECT u FROM AuthUser u WHERE u.username = :usernameOrEmail OR u.email = :usernameOrEmail")
    Optional<AuthUser> findByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail);

    /**
     * Check if user exists by username
     */
    boolean existsByUsername(String username);

    /**
     * Check if user exists by email
     */
    boolean existsByEmail(String email);

    /**
     * Find all active users
     */
    @Query("SELECT u FROM AuthUser u WHERE u.enabled = true")
    List<AuthUser> findAllActiveUsers();

    /**
     * Find users by role
     */
    List<AuthUser> findByRole(AuthUser.Role role);
}
