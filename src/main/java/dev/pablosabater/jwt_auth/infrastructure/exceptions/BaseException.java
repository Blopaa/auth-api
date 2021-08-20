package dev.pablosabater.jwt_auth.infrastructure.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BaseException extends RuntimeException {
    private final String title;
    private final String details;
    private final int status;
}
