package br.com.tt.petshop.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class AnimalInDTO {

    @NotBlank(message = "Informe o nome!")
    private String nome;

    @PastOrPresent(message = "Data informada deve ser passada!")
    @NotNull(message = "Informe a Data de Nascimento!")
    private LocalDate dataNascimento;

    @NotNull(message = "Informe o código do cliente")
    private Long cliente;

    @NotNull(message = "Informe o código da unidade")
    private Long unidade;

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public Long getUnidade() {
        return unidade;
    }

    public void setUnidade(Long unidade) {
        this.unidade = unidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
