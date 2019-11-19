package br.com.tt.petshop.controller;

import br.com.tt.petshop.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @RequestMapping(method = RequestMethod.GET, value="/admin/clientes")
    public String listar(Model model) {

        model.addAttribute("mensagem",
                "Bem vindo a lista de Clientes da PetShop");


        model.addAttribute("clientes",clienteService.listar());

        return "inicial";
    }

}
