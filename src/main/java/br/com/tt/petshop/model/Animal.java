package br.com.tt.petshop.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_ANIMAL")
public class Animal {

    @Id
    @Column(name = "ID_ANIMAL")
    private Long id;

    @Column
    private String nome;

    @Column
    private LocalDate dataNascimento;

    //Demarca que não é uma coluna do banco, deve ser ignorada
    //Mas por favor não usar
//    @Transient
//    private boolean flag;


    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void alterarNome(String novoNome) {
        this.nome = novoNome;
    }

}
