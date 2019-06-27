package com.lavamax.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lavamax.model.entities.Catalogo;
import com.lavamax.model.entities.Lavanderia;
import com.lavamax.model.entities.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer> {
	@Query("SELECT l FROM Local l WHERE l.lavanderia.id = ?1")
	List<Local> findLocalByLavanderiaId(int lavanderiaId);
}
