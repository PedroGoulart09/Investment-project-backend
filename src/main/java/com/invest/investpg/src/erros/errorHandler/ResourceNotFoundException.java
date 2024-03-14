package com.invest.investpg.src.erros.errorHandler;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object email) {
        super("Usuario com o e-mail: " + email + " não encontrado");
    }
}
