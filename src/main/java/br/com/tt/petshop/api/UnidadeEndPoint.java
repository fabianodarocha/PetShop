package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.UnidadeInDTO;
import br.com.tt.petshop.dto.UnidadeOutDTO;
import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
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
@RequestMapping(value = "/unidades")
@Api(description = "Api de Unidades que corresponde a cada estabelecimento")
public class UnidadeEndPoint {

    private final UnidadeService unidadeService;
    private final ModelMapper mapper;

    public UnidadeEndPoint(UnidadeService unidadeService, ModelMapper mapper) {
        this.unidadeService = unidadeService;
        this.mapper = mapper;
    }

    @GetMapping
    @ApiOperation("Responsável por buscar as unidades")
    public ResponseEntity<List<UnidadeOutDTO>> buscar(){
            List<UnidadeOutDTO> unidades =
                    unidadeService.listar().stream()
                    .map((u) -> mapper.map(u, UnidadeOutDTO.class))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(unidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadeOutDTO> buscar(@PathVariable Long id) {
        Unidade unid = unidadeService.buscarPorId(id);
        UnidadeOutDTO unidade = mapper.map(unid,UnidadeOutDTO.class);
        return ResponseEntity.ok(unidade);
    }

     /*
    @GetMapping("/{id}")
    public ResponseEntity<Unidade> buscarPorId(@PathVariable Long id) {
        Unidade unidade = unidadeService.buscarPorId(id);
        return ResponseEntity.ok(unidade);
    }    */

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@ApiParam("Identificador interno da UNIDADE")
                                      @PathVariable("id") Long id) {
        unidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity salvar(@Valid @RequestBody UnidadeInDTO dto) throws NegocioException {
        Unidade unidade = mapper.map(dto, Unidade.class);
        Unidade unidadeSalva = unidadeService.salvar(unidade);
        Long idCriado =  unidade.getId();
        URI location = URI.create(String.format("/unidades/%d", idCriado));
        return ResponseEntity.created(location).build();
    }



}
