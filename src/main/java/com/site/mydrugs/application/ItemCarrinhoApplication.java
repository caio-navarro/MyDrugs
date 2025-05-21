package com.site.mydrugs.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.site.mydrugs.models.ItemCarrinhoModels;
import com.site.mydrugs.repositories.ItemCarrinhoRepository;

@Component
public class ItemCarrinhoApplication {

    @Autowired
    ItemCarrinhoRepository repository;

    public ItemCarrinhoModels cadastrar(ItemCarrinhoModels item){
        return repository.save(item);
    }

    public List<ItemCarrinhoModels> listar(){
        return repository.findAll();
    }

    public ItemCarrinhoModels buscar(int id){
        return repository.findById(id).get();
    }

    public ItemCarrinhoModels atualizar(ItemCarrinhoModels item){
        return repository.save(item);
    }

    public void deletar(int id){
        repository.deleteById(id);
    }
}
