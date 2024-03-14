package com.invest.investpg.src.erros.errorHandler;

import java.io.Serial;

public class ResourceUserAlreadyExistException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceUserAlreadyExistException() {
        super("Try a new user");
    }
}
