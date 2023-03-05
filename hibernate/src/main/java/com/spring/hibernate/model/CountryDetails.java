package com.spring.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country_detail")
public class CountryDetails {

	@Id
	@Column(name="code")
	private String CountryCode;
	
	@Column(name="name")
	private String CountryName;
	
	@Column(name="region")
	private String CountryRegion;
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	public String getCountryRegion() {
		return CountryRegion;
	}
	public void setCountryRegion(String countryRegion) {
		CountryRegion = countryRegion;
	}
	@Override
	public String toString() {
		return "CountryDetails [CountryCode=" + CountryCode + ", CountryName=" + CountryName + ", CountryRegion="
				+ CountryRegion + "]";
	}
}
