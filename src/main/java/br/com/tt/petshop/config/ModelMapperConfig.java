package br.com.tt.petshop.config;

import br.com.tt.petshop.dto.AnimalOutDTO;
import br.com.tt.petshop.model.Animal;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        /*modelMapper.createTypeMap(Animal.class, AnimalOutDTO.class)
                .addMapping((animal) -> animal.getUnidade().getNome(),
                        ((dto, value) -> dto.setUnidade((String) value));*/

        modelMapper.createTypeMap(Animal.class, AnimalOutDTO.class)
                .addMapping((animal) -> animal.getUnidade().getNome(),
                        AnimalOutDTO::setUnidade)
                 .addMapping((animal) -> animal.getCliente().getNome(),
                            AnimalOutDTO::setCliente);

        ;

        return modelMapper;
    }

}
