package br.com.tt.petshop.api;

import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/unidades")
public class UnidadeEndPoint {

    private final UnidadeService unidadeService;

    public UnidadeEndPoint(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @GetMapping
    public ResponseEntity<List<Unidade>> buscar() {
        return ResponseEntity.ok(unidadeService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        unidadeService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Unidade unidade) throws NegocioException {
        Unidade unidadeSalva = unidadeService.salvar(unidade);
        Long idCriado =  unidade.getId();
        URI location = URI.create(String.format("/unidades/%d", idCriado));
        return ResponseEntity.created(location).build();
    }



}
