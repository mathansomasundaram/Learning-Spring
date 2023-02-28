package com.spring.Shapes;

public class Triangle extends Shape{

	public double calculateArea() {
		return ((getHeight()*getWidth())/2);
	}
}
