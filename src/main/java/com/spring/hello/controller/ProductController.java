package com.spring.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.hello.model.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	private final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public @ResponseBody Product insert(@RequestBody Product product){
		
		logger.debug("POST came to /product/insert");
		logger.debug(product.toString());
		
		return product;
	}
	
	@RequestMapping(value="/productHomeJsp", method=RequestMethod.GET)
	public String productHomeJSP(){
		logger.debug("GET came to Product JSP home..");
		return "product/product.jsp";
	}

	@RequestMapping(value="/productHomeHtml", method=RequestMethod.GET)
	public String productHomeHtml(){
		logger.debug("GET came to Product HTML home..");
		return "product/product.html";
	}
}
