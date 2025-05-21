package com.site.mydrugs.controller;

import com.site.mydrugs.application.CarrinhoApplication;
import com.site.mydrugs.models.CarrinhoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    CarrinhoApplication carrinhoApplication;

    @PostMapping("/cadastrar")
    public CarrinhoModels cadastrar(@RequestBody CarrinhoModels carrinho) {
        return carrinhoApplication.cadastrar(carrinho);
    }

    @GetMapping("/listar")
    public List<CarrinhoModels> listar() {
        return carrinhoApplication.listar();
    }

    @GetMapping("/buscar/{id}")
    public CarrinhoModels buscar(@PathVariable Integer id) {
        return carrinhoApplication.buscar(id);
    }

    @PutMapping("/atualizar")
    public CarrinhoModels atualizr(@RequestBody CarrinhoModels carrinho) {
        return carrinhoApplication.atualizar(carrinho);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Integer id) {
        carrinhoApplication.deletar(id);
    }
}
