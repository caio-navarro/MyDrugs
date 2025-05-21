package com.site.mydrugs.controller;

import com.site.mydrugs.application.EnderecoClienteApplication;
import com.site.mydrugs.models.EnderecoClienteModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("endereco")
public class EnderecoClienteController {

    @Autowired
    EnderecoClienteApplication enderecoApplication;

    @PostMapping("/cadastrar")
    public EnderecoClienteModels cadastrar(@RequestBody EnderecoClienteModels endereco) {
        return enderecoApplication.cadastrar(endereco);
    }

    @GetMapping("/listar")
    public List<EnderecoClienteModels> listar() {
        return enderecoApplication.listar();
    }

    @GetMapping("/buscar/{id}")
    public EnderecoClienteModels buscar(@PathVariable Integer id) {
        return enderecoApplication.buscar(id);
    }

    @PutMapping("/atualizar")
    public EnderecoClienteModels atualizar(@RequestBody EnderecoClienteModels endereco) {
        return enderecoApplication.atualizar(endereco);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Integer id) {
        enderecoApplication.deletar(id);
    }
}
