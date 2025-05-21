package com.site.mydrugs.controller;

import com.site.mydrugs.application.ClienteApplication;
import com.site.mydrugs.models.ClienteModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    ClienteApplication clienteApplication;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ClienteModels clienteModels){
        return clienteApplication.cadastrar(clienteModels);
    }

    @GetMapping("/listar")
    public List<ClienteModels> listar(){
        return clienteApplication.listar();
    }

    @GetMapping("/buscar/{id}")
    public ClienteModels buscar(@PathVariable Integer id){
        return clienteApplication.buscar(id);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<ClienteModels> atualizar(@RequestBody ClienteModels cliente){
        return clienteApplication.atualizar(cliente);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable Integer id){
        clienteApplication.deletar(id);
    }

    @PostMapping("/login")
    public String login(@RequestBody ClienteModels cliente) {
        return clienteApplication.login(cliente);
    }

}
