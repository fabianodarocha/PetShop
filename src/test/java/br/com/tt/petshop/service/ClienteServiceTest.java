package br.com.tt.petshop.service;

import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    private ClienteService clienteService;
    private static final String NOME_CLIENTE = "Fabiano Rocha";

    @BeforeEach
    public void inicia() {
        clienteService = new ClienteService();
    }

    @Test
    public void deveriaSalvarComSucesso() throws NegocioException {
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(NOME_CLIENTE);
        novoCliente.setCpf("123.456.789-10");
        clienteService.salvar(novoCliente);

    }

    @Test
    public void deveriaFalharComNomeSemSobrenome(){
        String nome = "Fulano";
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        NegocioException e = assertThrows(NegocioException.class, () -> clienteService.salvar(cliente));

        assertEquals("Precisa informar o nome composto de 2 partes",e.getMessage());
    }

    @Test
    public void deveriaFalharComCpfMenorQue11(){
        String cpf = "123.123.123-1";

        Cliente cliente = new Cliente();
        cliente.setNome(NOME_CLIENTE);
        cliente.setCpf(cpf);

        NegocioException e = assertThrows(NegocioException.class, () -> clienteService.salvar(cliente));
        assertEquals("O CPF precisa ter 11 digitos!",e.getMessage());

    }

    @Test
    public void deveriaFalharComCpfMaiorQue11(){
        String cpf = "123.123.123-011";

        Cliente cliente = new Cliente();
        cliente.setNome(NOME_CLIENTE);
        cliente.setCpf(cpf);

        NegocioException e = assertThrows(NegocioException.class, () -> clienteService.salvar(cliente));
        assertEquals("O CPF precisa ter 11 digitos!",e.getMessage());
    }

    @Test
    public void deveriaFalharComCpfConsiderandoFormatacao(){
        String cpf = "123.123.123";

        Cliente cliente = new Cliente();
        cliente.setNome(NOME_CLIENTE);
        cliente.setCpf(cpf);

        NegocioException e = assertThrows(NegocioException.class, () -> clienteService.salvar(cliente));
        assertEquals("O CPF precisa ter 11 digitos!",e.getMessage());


    }

}