package com.site.mydrugs.application;

import com.site.mydrugs.entities.EnderecoCliente;
import com.site.mydrugs.models.EnderecoClienteModels;
import com.site.mydrugs.repositories.EnderecoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class EnderecoClienteApplication {

    @Autowired
    EnderecoClienteRepository repository;

    public EnderecoClienteModels cadastrar(EnderecoClienteModels enderecoModels){
        EnderecoCliente enderecoCliente = EnderecoCliente.toCliente(enderecoModels);
        enderecoCliente.validar();
        return repository.save(enderecoModels);
    }

    public List<EnderecoClienteModels> listar(){
        return repository.findAll();
    }

    public EnderecoClienteModels buscar(int id){
        return repository.findById(id).get();
    }

    public EnderecoClienteModels atualizar(EnderecoClienteModels endereco){
        return repository.save(endereco);
    }

    public void deletar(int id){
        repository.deleteById(id);
    }
}
