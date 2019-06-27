package com.lavamax.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lavamax.model.entities.Catalogo;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo, Integer> {
	@Query("SELECT c FROM Catalogo c WHERE c.local.id = ?1")
	List<Catalogo> findCatalogoByLocalId(int localId);
}
