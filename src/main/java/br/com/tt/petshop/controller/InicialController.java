package br.com.tt.petshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping
@Controller
public class InicialController {

    @RequestMapping(method = RequestMethod.GET, value = "/admin")
    public String inicial() {
        return  "/inicial";
    }


}
