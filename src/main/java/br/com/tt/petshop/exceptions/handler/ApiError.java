package br.com.tt.petshop.exceptions.handler;

public class ApiError {

    private String codigo;
    private String descricao;

    public ApiError(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
