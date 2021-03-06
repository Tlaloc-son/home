package com.tlalocson.home.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
	
	@Insert("insert into prueba.contact(email, subject, message)values(#{p_email}, #{p_subject}, #{p_message})")		
	int insertContact(Map<String, Object> mapParameters);
}
