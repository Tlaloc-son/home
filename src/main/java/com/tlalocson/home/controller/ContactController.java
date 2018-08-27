package com.tlalocson.home.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tlalocson.home.model.ContactModel;
import com.tlalocson.home.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	public static final Log LOGGER = LogFactory.getLog(ContactController.class);
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public ResponseEntity<String> getRoles(@RequestBody ContactModel obj) {		
		
		JSONObject jsonResponse = new JSONObject();
		boolean result = contactService.insertContact(obj);
		try {
			jsonResponse.put("result", result);			
		} catch (JSONException e) {		
			LOGGER.error(e.getMessage());
		}
		
		return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
	}
}
