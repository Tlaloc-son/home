package com.tlalocson.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlalocson.home.entity.RolEntity;
import com.tlalocson.home.model.RolModel;
import com.tlalocson.home.model.converter.RolConverter;
import com.tlalocson.home.repository.RolMapper;
import com.tlalocson.home.service.RolService;

@Service("rolService")
public class RolServiceImpl implements RolService{	
	
	@Autowired
	private RolMapper rolMapper;
	
	@Autowired
	private RolConverter rolConverter;
	
	@Override
	public List<RolModel> getRoles() {
		List<RolEntity> entities = rolMapper.getRoles();
		return rolConverter.getModelsFromEntities(entities);
	}

	@Override
	public RolModel getRol(int idRol) {
		RolEntity entity = rolMapper.getRol(idRol);
		return rolConverter.getModelFromEntity(entity);
	}

}
