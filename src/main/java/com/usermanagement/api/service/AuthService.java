package com.usermanagement.api.service;

import com.usermanagement.api.dto.request.LoginRequest;
import com.usermanagement.api.dto.request.RegisterRequest;
import com.usermanagement.api.dto.response.AuthResponse;
import com.usermanagement.api.exception.DuplicateResourceException;
import com.usermanagement.api.model.AuthUser;
import com.usermanagement.api.repository.AuthUserRepository;
import com.usermanagement.api.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Authentication service for user registration, login, and token management.
 * 
 * Handles user authentication operations including registration,
 * login, token refresh, and token validation.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final AuthUserRepository authUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    /**
     * Register a new user
     */
    @Transactional
    public AuthResponse register(RegisterRequest request) {
        log.info("Registration attempt for username: {} and email: {}", request.getUsername(), request.getEmail());

        // Check if username already exists
        if (authUserRepository.existsByUsername(request.getUsername())) {
            throw new DuplicateResourceException("Username already in use: " + request.getUsername());
        }

        // Check if email already exists
        if (authUserRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already in use: " + request.getEmail());
        }

        // Create new user
        AuthUser user = new AuthUser();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(AuthUser.Role.USER); // Default role
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);

        AuthUser savedUser = authUserRepository.save(user);
        log.info("User registered successfully: {} (ID: {})", savedUser.getUsername(), savedUser.getId());

        // Generate tokens
        String accessToken = jwtUtil.generateToken(savedUser);
        String refreshToken = jwtUtil.generateRefreshToken(savedUser);

        return new AuthResponse(
                accessToken,
                refreshToken,
                86400L, // 24 hours
                new AuthResponse.UserInfo(
                        savedUser.getUsername(),
                        savedUser.getEmail(),
                        savedUser.getRole().name()
                )
        );
    }

    /**
     * Authenticate a user
     */
    @Transactional(readOnly = true)
    public AuthResponse login(LoginRequest request) {
        log.info("Login attempt for: {}", request.getUsernameOrEmail());

        // Authenticate user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsernameOrEmail(),
                        request.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        AuthUser user = (AuthUser) userDetails;

        log.info("Login successful for: {} (ID: {})", user.getUsername(), user.getId());

        // Generate tokens
        String accessToken = jwtUtil.generateToken(userDetails);
        String refreshToken = jwtUtil.generateRefreshToken(userDetails);

        return new AuthResponse(
                accessToken,
                refreshToken,
                86400L, // 24 hours
                new AuthResponse.UserInfo(
                        user.getUsername(),
                        user.getEmail(),
                        user.getRole().name()
                )
        );
    }

    /**
     * Refresh access token
     */
    @Transactional(readOnly = true)
    public AuthResponse refreshToken(String refreshToken) {
        log.info("Token refresh attempt");

        if (!jwtUtil.validateToken(refreshToken)) {
            throw new RuntimeException("Invalid or expired refresh token");
        }

        String username = jwtUtil.extractUsername(refreshToken);
        AuthUser user = authUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));

        // Generate new tokens
        String newAccessToken = jwtUtil.generateToken(user);
        String newRefreshToken = jwtUtil.generateRefreshToken(user);

        log.info("Tokens refreshed successfully for: {} (ID: {})", user.getUsername(), user.getId());

        return new AuthResponse(
                newAccessToken,
                newRefreshToken,
                86400L, // 24 hours
                new AuthResponse.UserInfo(
                        user.getUsername(),
                        user.getEmail(),
                        user.getRole().name()
                )
        );
    }

    /**
     * Validate if a token is valid
     */
    public boolean validateToken(String token) {
        return jwtUtil.validateToken(token);
    }

    /**
     * Extract user information from token
     */
    @Transactional(readOnly = true)
    public AuthUser getUserFromToken(String token) {
        String username = jwtUtil.extractUsername(token);
        return authUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username));
    }
}
