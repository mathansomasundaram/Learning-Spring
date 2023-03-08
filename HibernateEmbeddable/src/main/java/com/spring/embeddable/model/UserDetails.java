package com.spring.embeddable.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name="user_information")
public class UserDetails {

	@Id
	@GeneratedValue
	@Column(name="userId")
	private int userId;
	@Column(name="username")

	private String username;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name="user_Address",
			joinColumns=@JoinColumn(name="userId")
			)
	private Set<Address> address=new HashSet<>();;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", username=" + username + ", address=" + address + "]";
	}
	
}
