package br.com.tt.petshop.service;

import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.exceptions.RegistroNaoExisteException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private static final int QTD_MINIMA_PARTES_NOME = 2;
    private static final int TAMANHO_CPF = 11;
    private static final int TAMANHO_PARTE_NOME = 2;

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;

    }


    public List<Cliente> listar(Optional<String> nome, Optional<String> cpf) {

        if (nome.isPresent() && cpf.isPresent()) {
            return clienteRepository.buscaPorNomeCpf(nome.get(), cpf.get());
        } else if (nome.isPresent()) {
            //return clienteRepository.buscaPorNome(nome.get());
            return clienteRepository.FindByNome(nome.get());
        } else if (cpf.isPresent()) {
            return clienteRepository.buscaPorCpf(cpf.get());
        } else {
            return clienteRepository.findAll();
        }

    }

    public void salvar(Cliente cliente) throws NegocioException {

        validaQuantidadePartesNome(cliente);
        validaTamanhoCpf(cliente);
        validaTamanhoParteNome(cliente);

        clienteRepository.save(cliente);

    }

    private void validaTamanhoParteNome(Cliente cliente) throws NegocioException {
        String[] nomeCompleto = cliente.getNome().trim().split(" ");
        for (String parte : nomeCompleto) {
            if (parte.length() < TAMANHO_PARTE_NOME) {
                throw new NegocioException(String.format("Cada parte do nome precisa de no mínimo %d digitos!",TAMANHO_PARTE_NOME));
            }
        }
    }

    private void validaTamanhoCpf(Cliente cliente) throws NegocioException {
        if (cliente.getCpf().replaceAll("\\D","").length() != TAMANHO_CPF) {
            throw new NegocioException(String.format("O CPF precisa ter %d digitos!",TAMANHO_CPF));
        }
    }

    private void validaQuantidadePartesNome(Cliente cliente) throws NegocioException {
        int contaNome  = cliente.getNome().trim().split(" ").length;

        if (contaNome < QTD_MINIMA_PARTES_NOME) {
            throw new NegocioException(String.format("Precisa informar o nome composto de %d partes",QTD_MINIMA_PARTES_NOME));
        }
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoExisteException("Cliente não existe"));
    }


}
