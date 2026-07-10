package com.test.employees.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionController {

    @ExceptionHandler(EmployeeExistException.class)
    public ResponseEntity<String> employeeExistException( EmployeeExistException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> employeeNotFoundException( EmployeeNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> badCredentials(BadCredentialsException ex) {
        return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> accessDenied(AccessDeniedException ex) {
        return new ResponseEntity<>("You do not have permission to perform this action", HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> runtimeException(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
