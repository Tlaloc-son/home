package com.tlalocson.home.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UtilMapper {

	@Select("select current_time()")
	@ResultType(String.class)
	String getCurrentTime();
	
	@Select("select current_date()")
	@ResultType(String.class)
	String getCurrentDate();
}
