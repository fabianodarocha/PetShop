package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.AnimalInDTO;
import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.exceptions.RegistroNaoExisteException;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.repository.AnimalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final UnidadeService unidadeService;
    private final ClienteService clienteService;
    private final ModelMapper mapper;

    public AnimalService(AnimalRepository unidadeRepository, UnidadeService unidadeService, ClienteService clienteService, ModelMapper mapper) {
        this.animalRepository = unidadeRepository;
        this.unidadeService = unidadeService;
        this.clienteService = clienteService;
        this.mapper = mapper;
    }

    public List<Animal> listar(Optional<String> nome, Optional<Long> idCliente, Optional<Long> idUnidade) {


        Animal animal = new Animal();
        //nome.ifPresent(nomeStr -> animal.setNome(nomeStr)); Com Lambda

        if(nome.isPresent()) {
            animal.setNome(nome.get());
        }
        if (idCliente.isPresent()) {
            Cliente cliente = new Cliente();
            cliente.setId(idCliente.get());
            animal.setCliente(cliente);
        }
        if (idUnidade.isPresent()) {
            Unidade unidade = new Unidade();
            unidade.setId(idUnidade.get());
            animal.setUnidade(unidade);
        }

        return animalRepository.findAll(Example.of(animal));


        /*
        if (nome.isPresent())
            return animalRepository.listarPorNome(nome.get());
        }
        else {
            return animalRepository.findAll();
        }*/


    }

    public Animal salvar(AnimalInDTO animalInDTO) throws NegocioException {
        Animal animal = mapper.map(animalInDTO, Animal.class);
        animal.setCliente(obterClienteAnimal(animalInDTO.getCliente()));
        animal.setUnidade(obterUnidadeAnimal(animalInDTO.getUnidade()));
        return animalRepository.save(animal);
    }

    private Unidade obterUnidadeAnimal(Long idUnidade) {
        return unidadeService.buscarPorId(idUnidade);
    }

    private Cliente obterClienteAnimal(Long idCliente) {
        return clienteService.buscarPorId(idCliente);
    }

    public void deletar(Long id) {
        animalRepository.deleteById(id);
    }

    public Animal buscarPorId(Long id) {

        return animalRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoExisteException("Animal não existe"));
    }


}
