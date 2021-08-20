package dev.pablosabater.jwt_auth.dom.services;

import dev.pablosabater.jwt_auth.dom.dto.UserDto;
import dev.pablosabater.jwt_auth.infrastructure.exceptions.SearchException;
import dev.pablosabater.jwt_auth.infrastructure.exceptions.ValidationException;
import dev.pablosabater.jwt_auth.infrastructure.repositories.UserRepository;
import dev.pablosabater.jwt_auth.infrastructure.security.JWTUtils;
import dev.pablosabater.jwt_auth.infrastructure.security.PasswordHashing;
import dev.pablosabater.jwt_auth.web.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServices {

    private final  UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordHashing passwordHashing;
    private final JWTUtils jwtUtils;

    public AuthServices(UserRepository userRepository, UserMapper userMapper, PasswordHashing passwordHashing, JWTUtils jwtUtils) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordHashing = passwordHashing;
        this.jwtUtils = jwtUtils;
    }

    private final ValidationException nullData = new ValidationException("null data", "all data must be filled");

    public String signup(Optional<UserDto> userDto) {
        try {
            if (userDto.isEmpty()) {
                throw nullData;
            }
            var receivedUser = userMapper.toEntity(userDto.get());
            receivedUser.setPassword(passwordHashing.hash(receivedUser.getPassword()));
            var savedUser = userRepository.save(receivedUser);
            return jwtUtils.creation(savedUser);
        } catch (IllegalArgumentException e) {
            throw nullData;
        }
    }

    public String signin(Optional<UserDto> userDto) {

        if (userDto.isEmpty()) {
            throw nullData;
        }

        var receivedUser = userMapper.toEntity(userDto.get());
        var foundUser = userRepository.findByEmail(receivedUser.getEmail())
                .orElseThrow(() -> new SearchException("User not found", "unable to find a user with given email"));

        if (passwordHashing.matches(foundUser.getPassword(), receivedUser.getPassword()).equals(false)) {
            throw new ValidationException("mismatching password", "given password doesn't match");
        }

        return jwtUtils.creation(foundUser);
    }
}
