package com.lavamax.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lavamax.model.entities.Lavanderia;

@Repository
public interface LavanderiaRepository extends JpaRepository<Lavanderia, Integer> {

}
