package br.com.tt.petshop.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ClienteService {

    public List<String> listar() {
        return Arrays.asList("Antonio","Paulo");
    }

}
