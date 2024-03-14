package com.invest.investpg.src.erros.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

@Data
public class StandardError  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String error;
    private String message;
    private HttpStatus status;
}
