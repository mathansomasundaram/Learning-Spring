package com.spring.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	
	@Id @GeneratedValue
	private int empId;
	private String empName;

	@OneToOne
	@JoinColumn(name="emp_vehicleId")
	private Vehicle empVehicle;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Vehicle getEmpVehicle() {
		return empVehicle;
	}

	public void setEmpVehicle(Vehicle empVehicle) {
		this.empVehicle = empVehicle;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empVehicle=" + empVehicle + "]";
	}
	
}
