package com.spring.usage;

public class Laptop implements Computer {

	public Laptop(){
		System.out.println("Laptop Initialized");
	}
	@Override
	public void compile() {
		System.out.println("Code Compiled in Laptop");
	}

}
