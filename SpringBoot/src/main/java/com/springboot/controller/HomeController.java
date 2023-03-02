package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String homePage() {
		return "index";
	}
	
	@RequestMapping("/add")
	public ModelAndView addNumber(@RequestParam("number1")int i,
			@RequestParam("number2")int j) {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("result");
		int num3=i+j;
		
		mv.addObject("num3", num3);
		return mv;
	}
	
	/*
	  Below Method follows normal Servlets 
	  public String addNumber(HttpServletRequest request) {		
		int i=Integer.parseInt(request.getParameter("number1"));
		int j=Integer.parseInt(request.getParameter("number2"));
		
		int num3=i+j;
		HttpSession session=request.getSession();
		session.setAttribute("num3", num3);
		return "result.jsp";
	}*/
}
