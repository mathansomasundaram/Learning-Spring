package com.spring.AutoWire;

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
}
