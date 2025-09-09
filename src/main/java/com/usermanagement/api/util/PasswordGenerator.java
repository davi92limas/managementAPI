package com.usermanagement.api.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utility class for generating secure passwords.
 * 
 * Provides methods to generate random passwords with configurable
 * length and character sets including uppercase, lowercase, numbers,
 * and special characters.
 */
public class PasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+-=[]{}|;:,.<>?";
    
    private static final SecureRandom random = new SecureRandom();

    /**
     * Generate a random password with default settings:
     * - Length: 12 characters
     * - Includes: uppercase, lowercase, digits, special characters
     */
    public static String generatePassword() {
        return generatePassword(12, true, true, true, true);
    }

    /**
     * Generate a random password with specified length and default character sets
     */
    public static String generatePassword(int length) {
        return generatePassword(length, true, true, true, true);
    }

    /**
     * Generate a random password with full customization
     * 
     * @param length Length of the password
     * @param includeUppercase Include uppercase letters
     * @param includeLowercase Include lowercase letters
     * @param includeDigits Include digits
     * @param includeSpecialChars Include special characters
     * @return Generated password
     */
    public static String generatePassword(int length, boolean includeUppercase, 
                                        boolean includeLowercase, boolean includeDigits, 
                                        boolean includeSpecialChars) {
        
        if (length < 1) {
            throw new IllegalArgumentException("Password length must be at least 1");
        }
        
        if (!includeUppercase && !includeLowercase && !includeDigits && !includeSpecialChars) {
            throw new IllegalArgumentException("At least one character type must be included");
        }

        StringBuilder characterPool = new StringBuilder();
        List<Character> requiredChars = new ArrayList<>();

        if (includeUppercase) {
            characterPool.append(UPPERCASE);
            requiredChars.add(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        }
        
        if (includeLowercase) {
            characterPool.append(LOWERCASE);
            requiredChars.add(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        }
        
        if (includeDigits) {
            characterPool.append(DIGITS);
            requiredChars.add(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }
        
        if (includeSpecialChars) {
            characterPool.append(SPECIAL_CHARACTERS);
            requiredChars.add(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
        }

        // Generate remaining characters
        List<Character> passwordChars = new ArrayList<>(requiredChars);
        String pool = characterPool.toString();
        
        for (int i = requiredChars.size(); i < length; i++) {
            passwordChars.add(pool.charAt(random.nextInt(pool.length())));
        }

        // Shuffle the characters to avoid predictable patterns
        Collections.shuffle(passwordChars, random);

        // Convert to string
        StringBuilder password = new StringBuilder();
        for (Character c : passwordChars) {
            password.append(c);
        }

        return password.toString();
    }

    /**
     * Generate a simple alphanumeric password (no special characters)
     */
    public static String generateSimplePassword(int length) {
        return generatePassword(length, true, true, true, false);
    }

    /**
     * Generate a numeric PIN
     */
    public static String generateNumericPin(int length) {
        return generatePassword(length, false, false, true, false);
    }

    /**
     * Validate password strength
     * 
     * @param password Password to validate
     * @return PasswordStrength enum value
     */
    public static PasswordStrength validatePasswordStrength(String password) {
        if (password == null || password.length() < 4) {
            return PasswordStrength.VERY_WEAK;
        }
        
        int score = 0;
        
        // Length scoring
        if (password.length() >= 8) score++;
        if (password.length() >= 12) score++;
        if (password.length() >= 16) score++;
        
        // Character type scoring
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{}|;:,.<>?].*")) score++;
        
        // Complexity scoring
        if (password.matches(".*[a-z].*[A-Z].*") || password.matches(".*[A-Z].*[a-z].*")) score++;
        if (password.matches(".*[a-zA-Z].*[0-9].*") || password.matches(".*[0-9].*[a-zA-Z].*")) score++;
        
        return switch (score) {
            case 0, 1, 2 -> PasswordStrength.VERY_WEAK;
            case 3, 4 -> PasswordStrength.WEAK;
            case 5, 6 -> PasswordStrength.MEDIUM;
            case 7, 8 -> PasswordStrength.STRONG;
            default -> PasswordStrength.VERY_STRONG;
        };
    }

    /**
     * Enum representing password strength levels
     */
    public enum PasswordStrength {
        VERY_WEAK("Very Weak"),
        WEAK("Weak"),
        MEDIUM("Medium"),
        STRONG("Strong"),
        VERY_STRONG("Very Strong");

        private final String description;

        PasswordStrength(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}
