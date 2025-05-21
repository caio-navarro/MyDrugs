package com.site.mydrugs.repositories;

import com.site.mydrugs.models.EnderecoClienteModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoClienteRepository extends JpaRepository<EnderecoClienteModels, Integer>{

}
