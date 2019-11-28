package br.com.tt.petshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RegistroNaoExisteException extends RuntimeException {

    //@ResponseStatus(HttpStatus.NOT_FOUND)
    public  RegistroNaoExisteException(String message) {
        super(message);
    }
}
