package br.com.tt.petshop.service;

import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.model.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    private ClienteService clienteService;
    private static final String NOME_CLIENTE_VALIDO = "Fabiano Rocha";
    private static final String CPF_CLIENTE_VALIDO = "12345678911";

    @BeforeEach
    public void inicia() {
        clienteService = new ClienteService(clienteRepository);
    }

    @Test
    public void deveriaSalvarComSucesso() throws NegocioException {
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(NOME_CLIENTE_VALIDO);
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
    public void deveriaFalharComNomeParteMenorQue2(){
        String nome = "Fulano 1";
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(CPF_CLIENTE_VALIDO);
        NegocioException e = assertThrows(NegocioException.class, () -> clienteService.salvar(cliente));

        assertEquals("Cada parte do nome precisa de no mínimo 2 digitos!",e.getMessage());
    }


    @Test
    public void deveriaFalharComCpfMenorQue11(){
        String cpf = "123.123.123-1";

        Cliente cliente = new Cliente();
        cliente.setNome(NOME_CLIENTE_VALIDO);
        cliente.setCpf(cpf);

        NegocioException e = assertThrows(NegocioException.class, () -> clienteService.salvar(cliente));
        assertEquals("O CPF precisa ter 11 digitos!",e.getMessage());

    }

    @Test
    public void deveriaFalharComCpfMaiorQue11(){
        String cpf = "123.123.123-011";

        Cliente cliente = new Cliente();
        cliente.setNome(NOME_CLIENTE_VALIDO);
        cliente.setCpf(cpf);

        NegocioException e = assertThrows(NegocioException.class, () -> clienteService.salvar(cliente));
        assertEquals("O CPF precisa ter 11 digitos!",e.getMessage());
    }

    @Test
    public void deveriaFalharComCpfConsiderandoFormatacao(){
        String cpf = "123.123.123";

        Cliente cliente = new Cliente();
        cliente.setNome(NOME_CLIENTE_VALIDO);
        cliente.setCpf(cpf);

        NegocioException e = assertThrows(NegocioException.class, () -> clienteService.salvar(cliente));
        assertEquals("O CPF precisa ter 11 digitos!",e.getMessage());


    }

}