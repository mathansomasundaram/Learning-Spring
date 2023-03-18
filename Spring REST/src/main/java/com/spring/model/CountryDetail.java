package com.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="country_Detail")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"}, ignoreUnknown = true)

public class CountryDetail{

	@Id
	private String code;
	private String name;
	private String region;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Override
	public String toString() {
		return "CountryDetail [code=" + code + ", name=" + name + ", region=" + region + "]";
	}
}
