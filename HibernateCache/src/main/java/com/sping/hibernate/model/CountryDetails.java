package com.sping.hibernate.model;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQuery(name="findAllDetails",query = "from CountryDetails where CountryCode='IND'",hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true")})
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
