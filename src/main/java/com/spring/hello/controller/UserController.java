package com.spring.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.hello.model.User;
import com.spring.hello.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("currentUser")
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Model model){
		logger.debug("GET came to /user/register");
		model.addAttribute("userDTO", new User());
		return "user-register.jsp";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerProcess(@ModelAttribute("userDTO")User user){
		logger.debug("POST came to /user/register");
		logger.debug("user is: ",user);
		
		userService.save(user);
		
		return "redirect:/user/user-login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model){
		logger.debug("GET came to /user/login");
		model.addAttribute("userDTO", new User());
		return "user-login.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public  String loginProcess(@ModelAttribute("userDTO")User user, Model model){
		logger.debug("POST came to /user/login");
		logger.debug("user is: ",user);
		model.addAttribute("msg", "Login Success");
		User userFound = userService.getByUsername(user.getUsername());
		if(userFound==null){
			model.addAttribute("msg", "User not found!");
			logger.debug("User not found!");
			return "user-login.jsp";
		}
		if(!userFound.getPassword().equals(user.getPassword())){
			model.addAttribute("msg", "Invalid Password!");
			logger.debug("Invalid Password!");
			return "user-login.jsp";
		}
		
		logger.debug("login success: {}", user);
		model.addAttribute("currentUser", userFound);
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Model model, SessionStatus status){
		status.setComplete();
		model.addAttribute("currentUser", null);
		
		return "redirect:/user/login";
	}
	
}
