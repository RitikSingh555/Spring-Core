package com.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/home")
	public String home()
	{
		System.out.println("This is Controller"); 
		return "index";
	}

}