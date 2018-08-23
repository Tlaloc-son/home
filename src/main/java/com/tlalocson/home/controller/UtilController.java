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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tlalocson.home.service.UtilService;

@Controller
@RequestMapping("/util")
public class UtilController {

	public static final Log LOGGER = LogFactory.getLog(UtilController.class);
	
	@Autowired
	private UtilService utilService;
	
	@RequestMapping(value = "/time", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getCurrentTime() {		
		JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put("time", utilService.getCurrentTime());
		} catch (JSONException e) {		
			LOGGER.error(e.getMessage());
		}
		return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/date", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getCurrentDate() {		
		JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put("date", utilService.getCurrentDate());
		} catch (JSONException e) {		
			LOGGER.error(e.getMessage());
		}
		return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/date-time", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getCurrentDateTime() {		
		JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put("date", utilService.getCurrentDate());
			jsonResponse.put("time", utilService.getCurrentTime());
		} catch (JSONException e) {		
			LOGGER.error(e.getMessage());
		}
		return new ResponseEntity<>(jsonResponse.toString(), HttpStatus.OK);
	}
}
