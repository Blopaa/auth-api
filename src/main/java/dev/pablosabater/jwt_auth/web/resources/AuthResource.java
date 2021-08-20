package dev.pablosabater.jwt_auth.web.resources;

import dev.pablosabater.jwt_auth.dom.dto.UserDto;
import dev.pablosabater.jwt_auth.dom.services.AuthServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController()
@RequestMapping(value = "/auth")
public class AuthResource {
    private final AuthServices authServices;

    public AuthResource(AuthServices authServices) {
        this.authServices = authServices;
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<String> signup(Optional<UserDto> userDto){
        return new ResponseEntity<>(authServices.signup(userDto), HttpStatus.CREATED);
    }

    @PostMapping(value = "/signin")
    public ResponseEntity<String> signin(Optional<UserDto> userDto){
        return new ResponseEntity<>(authServices.signin(userDto), HttpStatus.OK);
    }
}
