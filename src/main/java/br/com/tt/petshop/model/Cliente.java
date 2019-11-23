package br.com.tt.petshop.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Auto-incremente
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
    //@SequenceGenerator( name = "CLIENTE_SEQ", sequenceName = "SQ_GENERATOR")
    @Column(name = "ID_CLIENTE")
    private Long id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String telefone;

    @Column
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
}
