package com.spring.AutoWire;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.Usage.Computer;

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
	
	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
	public void initialize() {
		System.out.println("Init Method");
	}
	
	public void destroy() {
		System.out.println("Destroyed");
	}
}
