package com.lavamax.service;

import java.util.List;

import com.lavamax.model.entities.Catalogo;
import com.lavamax.model.entities.Lavanderia;
import com.lavamax.model.entities.Local;

public interface LocalService extends CrudService<Local> {
	List<Local> listLocalByLavanderiaId(int lavanderiaId);
}