package com.site.mydrugs.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.site.mydrugs.models.ClienteModels;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModels, Integer>{

    Optional<ClienteModels> findByEmail(String email);

}
