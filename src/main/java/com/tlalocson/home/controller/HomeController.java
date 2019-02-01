package com.tlalocson.home.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tlalocson.home.controller.HomeController;

@Controller
@RequestMapping("/home")
public class HomeController {

	public static final Log LOGGER = LogFactory.getLog(HomeController.class);
	public static final String INDEX = "index";
	public static final String RAINDROPS = "raindrops";
	public static final String VIDEO = "video";
	
	@GetMapping("")
	public String emptyView() {
		return "redirect:/home/video";
	}
	
	@GetMapping("/")
	public String getHomeView() {
		return "redirect:/home/video";
	}	
	
	@GetMapping("/video")
	public ModelAndView getVideoView() {
		return new ModelAndView(VIDEO);
	}
}
