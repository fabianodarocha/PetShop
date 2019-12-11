package br.com.tt.petshop.client;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        ResponseEntity<SituacaoCreditoDto> response = restTemplate.getForEntity(
                "https://imersao-credito-api.herokuapp.com/credito/{cpf}",
                SituacaoCreditoDto.class,
                cpf);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new IllegalArgumentException("Erro ao processar serviço de Crédito");
        }

        /*return restTemplate.getForObject(
                "https://imersao-credito-api.herokuapp.com/credito/{cpf}",
                SituacaoCreditoDto.class,
                cpf);*/
    }


}
