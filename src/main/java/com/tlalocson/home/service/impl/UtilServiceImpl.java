package com.tlalocson.home.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlalocson.home.repository.UtilMapper;
import com.tlalocson.home.service.UtilService;

@Service("utilService")
public class UtilServiceImpl implements UtilService{

	@Autowired
	private UtilMapper utilMapper;
	
	@Override
	public String getCurrentTime() {		
		return utilMapper.getCurrentTime();
	}

	
}
