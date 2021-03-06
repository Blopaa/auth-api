package dev.pablosabater.jwt_auth.infrastructure.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException {
    private final String title;
    private final String details;
    private final int status;
}
