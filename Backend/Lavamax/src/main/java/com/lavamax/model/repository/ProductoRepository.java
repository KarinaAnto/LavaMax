package com.lavamax.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lavamax.model.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
