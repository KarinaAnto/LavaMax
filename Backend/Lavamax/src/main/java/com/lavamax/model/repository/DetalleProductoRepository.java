package com.lavamax.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lavamax.model.entities.DetalleProducto;

@Repository
public interface DetalleProductoRepository extends JpaRepository<DetalleProducto, Integer> {

}
