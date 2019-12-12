package br.com.tt.petshop.dto;

import javax.validation.constraints.NotNull;

public class ClienteInDto {

    @NotNull(message = "Informe o nome do cliente")
    private String nome;

    @NotNull(message = "Informe o cpf do cliente")
    private String cpf;

    @NotNull(message = "Informe o telefone do cliente")
    private String telefone;

    @NotNull(message = "Informe o email do cliente")
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
