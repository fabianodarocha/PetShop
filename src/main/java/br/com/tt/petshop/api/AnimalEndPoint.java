package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.AnimalInDTO;
import br.com.tt.petshop.dto.AnimalOutDTO;
import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.service.AnimalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/animais")
@Api(description = "Api de Animais que corresponde a cada animal")
public class AnimalEndPoint {

    private final AnimalService animalService;
    private final ModelMapper mapper;

    public AnimalEndPoint(AnimalService animalService, ModelMapper mapper) {
        this.animalService = animalService;
        this.mapper = mapper;
    }

    @GetMapping
    @ApiOperation("Responsável por buscar os animais")
    public ResponseEntity<List<AnimalOutDTO>> buscar(){
        List<AnimalOutDTO> animais =
                animalService.listar().stream()
                        .map((u) -> mapper.map(u, AnimalOutDTO.class))
                        .collect(Collectors.toList());
        return ResponseEntity.ok(animais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalOutDTO> buscar(@PathVariable Long id) {
        Animal ani = animalService.buscarPorId(id);
        AnimalOutDTO animal = mapper.map(ani,AnimalOutDTO.class);
        return ResponseEntity.ok(animal);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@ApiParam("Identificador interno do Animal")
                                  @PathVariable("id") Long id) {
        animalService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity salvar(@Valid @RequestBody AnimalInDTO dto) throws NegocioException {
        Animal animal = mapper.map(dto, Animal.class);
        Animal unidadeSalva = animalService.salvar(animal);
        Long idCriado =  animal.getId();
        URI location = URI.create(String.format("/animais/%d", idCriado));
        return ResponseEntity.created(location).build();
    }

}
