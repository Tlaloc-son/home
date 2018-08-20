package com.tlalocson.home.service;

import java.util.List;

import com.tlalocson.home.model.RolModel;

public interface RolService {

	public List<RolModel> getRoles();
	public RolModel getRol(int idRol);
}
