package com.site.mydrugs.application;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.site.mydrugs.models.CarrinhoModels;
import com.site.mydrugs.repositories.CarrinhoRepository;

@Component
public class CarrinhoApplication {

    @Autowired
    CarrinhoRepository carrinhoRepository;

    public CarrinhoModels cadastrar(CarrinhoModels carrinhoModels){
        

        return carrinhoRepository.save(carrinhoModels);
    }

    public List<CarrinhoModels> listar(){
        return carrinhoRepository.findAll();
    }

    public CarrinhoModels buscar(Integer id){
        return carrinhoRepository.findById(id).get();
    }

    public CarrinhoModels atualizar(CarrinhoModels carrinho){
        return carrinhoRepository.save(carrinho);
    }
    
    public void deletar(int id){
        carrinhoRepository.deleteById(id);
    }
}
