package com.lavamax.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lavamax.model.entities.TipoPago;

@Repository
public interface TipoPagoRepository extends JpaRepository<TipoPago, Integer>{

}
