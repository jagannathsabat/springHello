package com.spring.hello.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

	private final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String hello(){
		logger.debug("GET came to /");
		return "index";
	}
}
