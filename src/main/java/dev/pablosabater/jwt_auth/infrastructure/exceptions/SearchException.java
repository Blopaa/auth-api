package dev.pablosabater.jwt_auth.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SearchException extends BaseException{
    public SearchException(String title, String details) {
        super(title, details, 404);
    }
}
