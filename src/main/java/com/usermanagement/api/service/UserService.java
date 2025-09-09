package com.usermanagement.api.service;

import com.usermanagement.api.model.User;
import com.usermanagement.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service class for User entity operations.
 * 
 * Provides business logic for user management including
 * CRUD operations and validation methods.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        log.debug("Finding all users");
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        log.debug("Finding user by ID: {}", id);
        return userRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String email) {
        log.debug("Finding user by email: {}", email);
        return userRepository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByCpf(String cpf) {
        log.debug("Finding user by CPF: {}", cpf);
        return userRepository.findByCpf(cpf);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByPhone(String phone) {
        log.debug("Finding user by phone: {}", phone);
        return userRepository.findByPhone(phone);
    }

    @Transactional
    public User save(User user) {
        log.info("Saving user: {}", user.getName());
        return userRepository.save(user);
    }

    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting user with ID: {}", id);
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    public boolean existsByCpf(String cpf) {
        return userRepository.existsByCpf(cpf);
    }

    @Transactional(readOnly = true)
    public boolean existsByPhone(String phone) {
        return userRepository.existsByPhone(phone);
    }
}
