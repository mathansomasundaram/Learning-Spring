package com.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.CountryDetail;
public interface CountryRepo extends JpaRepository<CountryDetail,String>{

}
