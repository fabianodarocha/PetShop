package br.com.tt.petshop.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_UNIDADE")
public class Unidade {

    @Id
    @Column(name = "ID_UNIDADE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Auto-incremente
    private Long id;

    @Column
    private String nome;

    @Column
    private String endereco;

    @Column
    private String telefone;

    @Column
    private String cnpj;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
