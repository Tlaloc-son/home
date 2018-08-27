package com.tlalocson.home.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import com.tlalocson.home.entity.ContactEntity;

@Mapper
@Repository
public interface ContactMapper {

	@Select("select id_contact, email, subject, message from contact")
	@Results({
	  @Result(property = "idContact", column = "id_contact", id = true),
	  @Result(property = "email", column = "email"),
	  @Result(property = "subject", column = "subject"),
	  @Result(property = "message", column = "message"),
	}) 
	List<ContactEntity> getContactsMapper();
	
	@Select("{call prueba.sp_contact_insert("
			+ "#{p_email, 	jdbcType=VARCHAR, mode=IN}, "
			+ "#{p_subject, jdbcType=VARCHAR, mode=IN}, "
			+ "#{p_message, jdbcType=VARCHAR, mode=IN}, "
			+ "#{p_result, 	jdbcType=VARCHAR, mode=OUT}"
			+ ")}")
	@Options(statementType = StatementType.CALLABLE)	
	void inserContact(Map<String, Object> mapParameters);
}
