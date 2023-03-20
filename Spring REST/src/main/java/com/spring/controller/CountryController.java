package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.CountryDetail;
import com.spring.repository.CountryRepo;

@RestController
public class CountryController {

	@Autowired
	CountryRepo repo;

	@GetMapping(path="countryDetails",produces = {"application/xml"})
	public List<CountryDetail> getCountryDetails(){
		return repo.findAll();
	}
	
	
	@GetMapping("countryDetail/{code}")
	public CountryDetail getCountry(@PathVariable("code") String code) {
		return repo.findById(code).orElse(null);
	}
	
	@PostMapping(path="countryDetail",consumes = {"application/xml"})
	public CountryDetail loadCounty(@RequestBody CountryDetail c) {
		return repo.save(c);
	}
	
}
