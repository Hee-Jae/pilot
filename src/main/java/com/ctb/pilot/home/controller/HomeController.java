package com.ctb.pilot.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String home(Model model) {
		return "view/home";
	}

	@RequestMapping(value = "/m/index.do", method = RequestMethod.GET)
	public String mobile(Model model) {
		return "view/mobile";
	}

}
