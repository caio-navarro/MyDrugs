package com.site.mydrugs.controller;

import com.site.mydrugs.application.DrogaApplication;
import com.site.mydrugs.models.DrogaModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/droga")
@CrossOrigin(origins = "*")
public class DrogaController {

    @Autowired
    DrogaApplication drogaApplication;

    @PostMapping("/cadastrar")
    public DrogaModels cadastrar(@RequestBody DrogaModels droga){
        return drogaApplication.cadastrar(droga);
    }

    @GetMapping("/listar")
    public List<DrogaModels> listar() {
        return drogaApplication.listar();
    }

    @GetMapping("/buscar/{id}")
    public DrogaModels buscar(@PathVariable int id) {
        return drogaApplication.buscar(id);
    }

    @PutMapping("/atualizar")
    public DrogaModels atualizar(@RequestBody DrogaModels droga){
        return drogaApplication.atualizar(droga);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable int id) {
        drogaApplication.deletar(id);
    }
}
