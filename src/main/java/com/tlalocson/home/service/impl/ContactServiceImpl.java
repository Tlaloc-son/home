package com.tlalocson.home.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlalocson.home.model.ContactModel;
import com.tlalocson.home.repository.ContactMapper;
import com.tlalocson.home.service.ContactService;

@Service("contactService")
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactMapper contactMapper;
	
	@Override
	public boolean insertContact(ContactModel model) {
		Map<String, Object> params = new HashMap<>();
		params.put("p_email", model.getEmail());
		params.put("p_subject", model.getSubject());
		params.put("p_message", model.getMessage());
		contactMapper.inserContact(params);
		String result = (String) params.get("p_result");
		if(result.equals("EXITO"))
			return true;
		return false;
	}

	
}
