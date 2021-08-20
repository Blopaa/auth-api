package dev.pablosabater.jwt_auth.infrastructure.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BaseException> validationExceptionHandler (ValidationException ex) {
        return new ResponseEntity<>(BaseException.builder()
                .title(ex.getTitle())
                .details(ex.getDetails())
                .status(ex.getStatus())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SearchException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<BaseException> searchExeptionHandler (ValidationException ex) {
        return new ResponseEntity<>(BaseException.builder()
                .title(ex.getTitle())
                .details(ex.getDetails())
                .status(ex.getStatus())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }
}

