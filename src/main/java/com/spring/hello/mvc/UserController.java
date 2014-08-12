package com.spring.hello.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.hello.model.User;
import com.spring.hello.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Model model){
		logger.debug("GET came to /user/register");
		model.addAttribute("userDTO", new User());
		return "user-register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerProcess(@ModelAttribute("userDTO")User user){
		logger.debug("POST came to /user/register");
		logger.debug("user is: ",user);
		userService.save(user);
		return "redirect:login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model){
		logger.debug("GET came to /user/login");
		model.addAttribute("userDTO", new User());
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginProcess(@ModelAttribute("userDTO")User user, Model model){
		logger.debug("POST came to /user/login");
		logger.debug("user is: ",user);
		model.addAttribute("msg", "Login Success");
		
		return "login";
	}
	
	
}
