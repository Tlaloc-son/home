package com.tlalocson.home.model.converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.tlalocson.home.entity.RolEntity;
import com.tlalocson.home.model.RolModel;

@Component("rolConverter")
public class RolConverter implements Converter<RolEntity, RolModel>{

	public static final Log LOGGER = LogFactory.getLog(RolConverter.class);
	
	@Override
	public RolModel getModelFromEntity(RolEntity entity){
		RolModel obj = new RolModel();
		try {
			obj.setIdRol(entity.getIdRol());
			obj.setRol(entity.getRol());
		}catch (Exception e) {
			LOGGER.info("Null RolEntity");
		}		
		return obj;
	}

	@Override
	public RolEntity getEntityFromModel(RolModel model){
		RolEntity obj = new RolEntity();
		try {
			obj.setIdRol(model.getIdRol());
			obj.setRol(model.getRol());
		}catch (Exception e) {
			LOGGER.info("Null RolModel");
		}		
		return obj;
	}

	@Override
	public List<RolEntity> getEntitiesFromModels(List<RolModel> models) {
		List<RolEntity> list = new ArrayList<>();
		for(RolModel model : models) {
			list.add(getEntityFromModel(model));
		}
		return list;
	}

	@Override
	public List<RolModel> getModelsFromEntities(List<RolEntity> entities) {
		List<RolModel> list = new ArrayList<>();
		for(RolEntity entity : entities) {
			list.add(getModelFromEntity(entity));
		}
		return list;
	}
}
