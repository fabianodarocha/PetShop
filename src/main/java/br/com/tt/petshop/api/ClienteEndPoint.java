package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.ClienteOutDTO;
import br.com.tt.petshop.dto.UnidadeOutDTO;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
@Api(description = "Api de Clientes que corresponde a cada pessoa")
public class ClienteEndPoint {

    private final ClienteService clienteService;
    private final ModelMapper mapper;

    public ClienteEndPoint(ClienteService clienteService, ModelMapper mapper) {
        this.clienteService = clienteService;
        this.mapper = mapper;
    }


    @GetMapping
    @ApiOperation("Responsável por buscar os clientes")
    public ResponseEntity<List<ClienteOutDTO>> listar(
            //@RequestParam(required = false) String nome
            @RequestParam("nome") Optional<String> nome,
            @RequestParam("cpf") Optional<String> cpf
    ){

        //List<Cliente> lista = clienteService.listar(nome,cpf);

        List<ClienteOutDTO> cliente =
                clienteService.listar(nome, cpf).stream()
                        .map((u) -> mapper.map(u, ClienteOutDTO.class))
                        .collect(Collectors.toList());
        return ResponseEntity.ok(cliente);
    }


}
