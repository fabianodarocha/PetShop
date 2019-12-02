package br.com.tt.petshop.service;

import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.exceptions.RegistroNaoExisteException;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository unidadeRepository) {
        this.animalRepository = unidadeRepository;
    }

    public List<Animal> listar() {
        return animalRepository.findAll();
    }

    public Animal salvar(Animal animal) throws NegocioException {
        return animalRepository.save(animal);
    }

    public void deletar(Long id) {
        animalRepository.deleteById(id);
    }

    public Animal buscarPorId(Long id) {

        return animalRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoExisteException("Animal não existe"));
    }


}
