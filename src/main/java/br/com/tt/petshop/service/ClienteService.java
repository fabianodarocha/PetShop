package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> listar() {
        return clientes;
    }

    public void salvar(Cliente cliente) {
       this.clientes.add(cliente);
    }


}
