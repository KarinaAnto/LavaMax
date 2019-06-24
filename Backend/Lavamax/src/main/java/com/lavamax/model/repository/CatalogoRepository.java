package com.lavamax.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lavamax.model.entities.Catalogo;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Integer> {

}
