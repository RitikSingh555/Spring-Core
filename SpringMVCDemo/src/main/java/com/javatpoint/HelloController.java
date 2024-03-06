package com.javatpoint;  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;  
@Controller("spring")  
public class HelloController {  
	
/*
@RequestMapping("/")  
    public String display()  
    {  
        return "index";  
    }     */
	@RequestMapping("/home")
	public String home(Model model)
	{
		System.out.println("This is home url");
		
		model.addAttribute("name","Durgesh Tiwari");
		return "index";
	}

}  