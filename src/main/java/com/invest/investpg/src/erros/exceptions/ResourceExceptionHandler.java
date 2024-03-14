package com.invest.investpg.src.erros.exceptions;

import com.invest.investpg.src.erros.errorHandler.ResourceNotFoundException;
import com.invest.investpg.src.erros.errorHandler.ResourceUserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e) {
        String error = "Login inválido, usuário não encontrado";
        StandardError err = new StandardError();
        err.setError(error);
        err.setMessage(e.getMessage());
        HttpStatus status = HttpStatus.NOT_FOUND;
        err.setStatus(status);
        return ResponseEntity.status(404).body(err);
    }

    @ExceptionHandler(ResourceUserAlreadyExistException.class)
    public ResponseEntity<StandardError> resourceUserAlreadyExist(ResourceUserAlreadyExistException e) {
        String error = "E-mail or password already exist";
        StandardError err = new StandardError();
        err.setError(error);
        err.setMessage(e.getMessage());
        HttpStatus status = HttpStatus.BAD_REQUEST;
        err.setStatus(status);
        return ResponseEntity.status(400).body(err);
    }

}
