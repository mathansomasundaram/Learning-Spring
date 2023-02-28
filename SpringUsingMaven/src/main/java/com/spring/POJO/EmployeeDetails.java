package com.spring.POJO;

public class EmployeeDetails {

	private double salary;
	private String empId;
	EmployeeDetails(double salary,String empId){
		this.salary=salary;
		System.out.println("EmpId:"+empId);
		System.out.println("Object Created for EmployeeDetails");
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void display() {
		System.out.println("First Spring Project using maven");
	}
}
