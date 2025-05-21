package com.site.mydrugs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.mydrugs.models.DrogaModels;

@Repository
public interface DrogaRepository extends JpaRepository<DrogaModels, Integer>{

}
