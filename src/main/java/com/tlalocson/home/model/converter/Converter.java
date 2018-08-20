package com.tlalocson.home.model.converter;

import java.util.List;

public interface Converter<E,M> {

	public M getModelFromEntity(E entity);
	public E getEntityFromModel(M model);
	public List<E> getEntitiesFromModels(List<M> models);
	public List<M> getModelsFromEntities(List<E> entities);
}
