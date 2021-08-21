package dev.pablosabater.jwt_auth.infrastructure.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ApiError {
    private final String title;
    private final String details;
    private final int status;
}
