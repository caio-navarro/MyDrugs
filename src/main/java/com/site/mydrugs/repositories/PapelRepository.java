package com.site.mydrugs.repositories;

import com.site.mydrugs.models.PapelModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PapelRepository extends JpaRepository<PapelModels, Integer> {
}
