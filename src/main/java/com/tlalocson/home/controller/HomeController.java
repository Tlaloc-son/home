package com.tlalocson.home.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tlalocson.home.controller.HomeController;
import com.tlalocson.home.util.AppProperties;
import com.tlalocson.home.util.Strings;

@Controller
public class HomeController {

	public static final Log LOGGER = LogFactory.getLog(HomeController.class);
	
	@Autowired
	private AppProperties appProperties;
	
	@GetMapping("")
	public String emptyView() {
		return "redirect:/";
	}
	
	@GetMapping("/")
	public ModelAndView getHomeView() {
		ModelAndView model = new ModelAndView(Strings.VIDEO);
		model.addObject("context", appProperties.getContext());
		return model;
	}

}
