package com.java.demo;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		System.out.println("Home method called.");
		return "index.jsp";
	}
	
	@GetMapping("/alien")
	public String Alien() {
		System.out.println("Home method called.");
		return "AddAlien.jsp";
	}
	
	@GetMapping("add")
	public ModelAndView add(@RequestParam("num1") int num1,@RequestParam("num2") int num2,ModelAndView mv) {
		System.out.println("Satya in add");
		int result=num1+num2;
		mv.addObject("result", result);
		mv.setViewName("result");
		//session.setAttribute("result", result);
		return mv;
	}
	
	@GetMapping("addAlien")
	public Model addAlien(@RequestParam("aid") int id, @RequestParam("aname") String name,Model model) {
	    System.out.println("Hello alien");
	    Alien alien = new Alien();
	    alien.setAid(id);
	    alien.setAname(name);
	    model.addAttribute("alien", alien);
//	    ModelAndView mv = new ModelAndView();
//	    mv.addObject("alien", alien);
//	    mv.setViewName("showAlien");
	   // session.setAttribute("alien", alien);
	    return model;
	}
}
