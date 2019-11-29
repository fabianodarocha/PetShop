package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.UnidadeOutDTO;
import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/unidades")
@Api(description = "Api de Unidades que corresponde a cada estabelecimento")
public class UnidadeEndPoint {

    private final UnidadeService unidadeService;

    public UnidadeEndPoint(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @GetMapping
    @ApiOperation("Responsável por buscar as unidades")
    public ResponseEntity<List<UnidadeOutDTO>> buscar(){

        return ResponseEntity.ok(unidadeService
                .listar().stream()
                .map(u -> new UnidadeOutDTO(u))
                .collect(Collectors.toList()));
    }

   // @GetMapping("/{id}")
   // public ResponseEntity<Unidade> buscar(@PathVariable Long id) {
   //     return ResponseEntity.ok(null);
   // }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@ApiParam("Identificador interno da UNIDADE")
                                      @PathVariable("id") Long id) {
        unidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> buscarPorId(@PathVariable Long id) {
        Unidade unidade = unidadeService.buscarPorId(id);
        return ResponseEntity.ok(unidade);
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Unidade unidade) throws NegocioException {
        Unidade unidadeSalva = unidadeService.salvar(unidade);
        Long idCriado =  unidade.getId();
        URI location = URI.create(String.format("/unidades/%d", idCriado));
        return ResponseEntity.created(location).build();
    }



}
