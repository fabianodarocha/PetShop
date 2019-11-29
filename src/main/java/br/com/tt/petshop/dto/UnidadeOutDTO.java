package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.Unidade;

public class UnidadeOutDTO {

    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String cnpj;

    public UnidadeOutDTO(Unidade u) {
        this.setId(u.getId());
        this.setNome(u.getNome());
        this.setCnpj(u.getCnpj());
        this.setEndereco(u.getEndereco());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
