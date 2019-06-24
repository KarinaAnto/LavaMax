package com.lavamax.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lavamax.model.entities.Publicacion;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {

}
