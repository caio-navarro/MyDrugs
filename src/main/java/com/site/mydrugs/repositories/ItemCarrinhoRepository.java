package com.site.mydrugs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.mydrugs.models.ItemCarrinhoModels;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinhoModels, Integer>{

}
