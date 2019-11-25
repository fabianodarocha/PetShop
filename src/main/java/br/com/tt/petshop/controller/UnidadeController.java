package br.com.tt.petshop.controller;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class UnidadeController {

    private UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @RequestMapping(method = RequestMethod.GET, value="/admin/unidades")
    public String listar(Model model) {
        model.addAttribute("mensagem",
                "Bem vindo a lista de Unidades da PetShop");

        model.addAttribute("unidades",unidadeService.listar());
        return "unidade/unidade";
    }

    @RequestMapping(method = RequestMethod.GET, value="/admin/unidades/criar")
    public String unidadeCriar(Model model) {
        model.addAttribute("novaUnidade",new Unidade());
        return "unidade/unidade_criar";
    }

    @RequestMapping(method = RequestMethod.POST, value="/admin/unidades/criarNova")
    public String criarNovo(Unidade unidade, Model model) {

        try {
            unidadeService.salvar(unidade);
            model.addAttribute("mensagem", "Unidade salva com sucesso");
        } catch (Exception e) {
            model.addAttribute("mensagem", "Erro: ".concat(e.getMessage()));
        }

        model.addAttribute("unidades",unidadeService.listar());
        return "unidade/unidade";
    }


}
