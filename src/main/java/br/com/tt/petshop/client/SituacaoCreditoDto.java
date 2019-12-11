package br.com.tt.petshop.client;

public class SituacaoCreditoDto {

    private SituacaoCredito situacao;
    private Integer pontos;

    public SituacaoCredito getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCredito situacao) {
        this.situacao = situacao;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public Boolean isRegular() {
        return SituacaoCredito.NORMAL.equals(situacao);
    }

}
