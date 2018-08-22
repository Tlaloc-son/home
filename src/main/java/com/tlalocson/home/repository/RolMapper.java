package com.tlalocson.home.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import com.tlalocson.home.entity.RolEntity;

@Mapper
@Repository
public interface RolMapper {

	@Select("select id_rol, rol from cat_rol")
	@Results({
	  @Result(property = "idRol", column = "id_rol", id = true),
	  @Result(property = "rol", column = "rol")
	}) 
	List<RolEntity> getRolesMapper();
	
	@ResultMap("getRolesMapper-void")
	@Select("call prueba.sp_get_roles()")
	List<RolEntity> getRoles();
	
	@ResultMap("getRolesMapper-void")
	@Select("select prueba.fn_get_rol(#{idRol}) as rol")
	RolEntity getRol(int idRol);
	
	@Select("{call prueba.sp_get_rol(#{idRol, jdbcType=INTEGER, mode=IN}, #{rol, jdbcType=VARCHAR, mode=OUT})}")
	@Options(statementType = StatementType.CALLABLE)	
	void executeStoreProcedureInOut(Map<String, Object> mapParameters);
	
	@Select("select prueba.fn_get_rol(#{idRol})")
	@Options(statementType = StatementType.CALLABLE)
	@ResultType(String.class)
	String executeFunction(int idRol);
}
