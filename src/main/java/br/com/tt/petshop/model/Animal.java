package br.com.tt.petshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "TB_ANIMAL")
public class Animal {

    @Id
    @Column(name = "ID_ANIMAL")
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Auto-incremente
    private Long id;

    @Column
    @NotBlank
    private String nome;

    @Column
    @NotNull
    private LocalDate dataNascimento;

    @ManyToOne
    @JoinColumn(name = "ID_UNIDADE")
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    //Demarca que não é uma coluna do banco, deve ser ignorada
    //Mas por favor não usar, user DTO
//    @Transient
//    private boolean flag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
