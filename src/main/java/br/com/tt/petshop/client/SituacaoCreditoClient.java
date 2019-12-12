package br.com.tt.petshop.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//Poderia se um @Service mas preferimos deixar genérico
@Component
public class SituacaoCreditoClient {

    private final RestTemplate restTemplate;
    private final String apisCreditoUrl;

    public SituacaoCreditoClient(RestTemplate restTemplate,
                                 @Value("${apis.credito.url}") String apisCreditoUrl) {
        this.restTemplate = restTemplate;
        this.apisCreditoUrl = apisCreditoUrl;
    }

    public SituacaoCreditoDto consultaSituacao(String cpf) {
        ResponseEntity<SituacaoCreditoDto> response = restTemplate.getForEntity(
                apisCreditoUrl,
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
