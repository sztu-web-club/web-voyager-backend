package io.github.sztuwebclub.webvoyager.constant.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private PasswordUtil() {
    }

    public static String encrypt(String password) {
        return passwordEncoder.encode(password);
    }

    public static boolean match(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
