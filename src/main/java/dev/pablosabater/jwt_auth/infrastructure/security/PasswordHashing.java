package dev.pablosabater.jwt_auth.infrastructure.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordHashing {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public String hash(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public Boolean matches(String encryptedPassword, String inputPassword) {
        return bCryptPasswordEncoder.matches(inputPassword, encryptedPassword);
    }
}
