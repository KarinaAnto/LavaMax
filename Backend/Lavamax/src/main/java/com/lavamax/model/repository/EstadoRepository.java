package com.lavamax.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lavamax.model.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
