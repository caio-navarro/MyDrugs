package com.site.mydrugs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.site.mydrugs.application.ItemCarrinhoApplication;
import com.site.mydrugs.models.ItemCarrinhoModels;

@RestController
@RequestMapping("/itens-carrinhos")
public class ItemCarrinhoController {
    @Autowired
    private ItemCarrinhoApplication application;


    @PostMapping("/cadastrar")
    public ItemCarrinhoModels cadastrar(@RequestBody ItemCarrinhoModels item){
        return application.cadastrar(item);
    }

    @GetMapping("/listar")
    public List<ItemCarrinhoModels> listar(){
        return application.listar();
    }

    @GetMapping("/buscar/{id}")
    public ItemCarrinhoModels buscar(@PathVariable int id){
        return application.buscar(id);
    }

    @PostMapping("/atualizar")
    public ItemCarrinhoModels atualizar(@RequestBody ItemCarrinhoModels item){
        return application.atualizar(item);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable int id){
        application.deletar(id);
    }
}
