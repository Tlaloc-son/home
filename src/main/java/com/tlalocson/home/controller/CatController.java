package com.tlalocson.home.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tlalocson.home.service.RolService;
import com.google.gson.Gson;
import com.tlalocson.home.model.RolModel;

@Controller
@RequestMapping("/cat")
public class CatController {

	public static final Log LOGGER = LogFactory.getLog(CatController.class);

	@Autowired
	private RolService rolService;

	@RequestMapping(value = "/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getRoles() {
		Gson gson = new Gson();
		List<RolModel> roles = rolService.getRoles();
		String jsonResponse = gson.toJson(roles);
		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rol/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getRol(@PathVariable(value="id") int idRol) {
		Gson gson = new Gson();
		RolModel rol = rolService.getRol(idRol);
		String jsonResponse = gson.toJson(rol);
		return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
	}
}
