package com.spring.autowiredannotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.usage.Computer;

@Component("user")
public class User {

	private String userName;
	private Computer computer;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Computer getComputer() {
		return computer;
	}
	
	@Autowired
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	@PostConstruct
	public void initialize() {
		System.out.println("Init Method");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroyed");
	}
}
