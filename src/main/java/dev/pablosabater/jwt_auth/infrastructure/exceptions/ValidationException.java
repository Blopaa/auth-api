package dev.pablosabater.jwt_auth.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ValidationException extends BaseException{
    public ValidationException(String title, String details) {
        super(title, details, 400);
    }
}
