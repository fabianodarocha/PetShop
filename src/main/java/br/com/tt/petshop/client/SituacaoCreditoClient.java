package br.com.tt.petshop.client;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//Poderia se um @Service mas preferimos deixar genérico
@Component
public class SituacaoCreditoClient {

    private final RestTemplate restTemplate;

    public SituacaoCreditoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SituacaoCreditoDto consultaSituacao(String cpf) {
        return null;
    }


}
