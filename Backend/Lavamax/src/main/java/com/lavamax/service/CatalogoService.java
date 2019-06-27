package com.lavamax.service;

import java.util.List;

import com.lavamax.model.entities.Catalogo;

public interface CatalogoService extends CrudService<Catalogo> {

	List<Catalogo> listLocalId(int localId);
}
