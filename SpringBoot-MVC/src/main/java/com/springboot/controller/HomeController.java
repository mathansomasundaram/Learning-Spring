package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.model.Employee;

@Controller
public class HomeController {

	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("welcome", "Welcome Employee's");
	}
	
	@RequestMapping("/")
	public String homePage() {
		return "index";
	}
	
	@PostMapping("/add")
	public String addEmployee(@ModelAttribute Employee employee,Model m) {
		m.addAttribute("employee", employee);
		return "result";
	}
}
