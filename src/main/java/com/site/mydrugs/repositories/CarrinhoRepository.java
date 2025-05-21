package com.site.mydrugs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.mydrugs.models.CarrinhoModels;

@Repository
public interface CarrinhoRepository extends JpaRepository<CarrinhoModels, Integer>{

}
