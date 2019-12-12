package br.com.tt.petshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NegocioException extends Exception {

    public NegocioException(String mensagem) {
        super(mensagem);
    }

}
