package br.com.tt.petshop.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UnidadeInDTO {

    @NotBlank(message = "Informe o nome!")
    private String nome;

    @NotBlank(message = "Informe o endereço!")
    private String endereco;

    @NotBlank(message = "Informe o Telefone!")
    @Pattern(regexp = "\\([0-9]{2}\\)[ ][0-9]{4}[-][0-9]{4}", message = "Informar o telefone no formato (XX) XXXX-XXXX")
    private String telefone;

    @NotBlank
    private String cnpj;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
