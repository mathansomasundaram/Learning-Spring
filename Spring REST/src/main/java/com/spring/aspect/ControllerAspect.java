package com.spring.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.spring.model.CountryDetail;
@Aspect
@Component
public class ControllerAspect {

	private static final Logger logger=Logger.getLogger(ControllerAspect.class);
	
	
	@Before("execution(public * com.spring.controller.CountryController.getCountryDetails())")
	public void beforeLog() {
		logger.info("Before Execution");
	}
	
	@AfterThrowing("execution(public java.util.List<com.spring.model.CountryDetail> com.spring.controller.CountryController.getCountryDetails())")
	public void exceptionLog() {
		logger.error("Exception Log");
	}
	
	@After("execution(public java.util.List<com.spring.model.CountryDetail> com.spring.controller.CountryController.getCountryDetails())")
	public void afterLog() {
		logger.info("After Execution");
	}
	
	@AfterReturning("execution(public java.util.List<com.spring.model.CountryDetail> com.spring.controller.CountryController.getCountryDetails())")
	public void afterReturningLog() {
		logger.info("After Returning");
	}
	
	@Before("execution(public * com.spring.controller.CountryController.getCountry(String))")
	public void getCountryDetail(JoinPoint joinPoint) {
		 Object[] args = joinPoint.getArgs();
		 String code = (String) args[0];
		 if(!code.equalsIgnoreCase("ABW"))
			 throw new RuntimeException("Access denied.");
		 logger.info("Code:"+code);  
		logger.info("Before Execution");
	}
	
	@AfterReturning(pointcut="execution(public * com.spring.controller.CountryController.getCountry(String))",returning ="countryDetails")
	public void getCountryDetailObject(CountryDetail countryDetails) {
		 logger.info("After Execution");
		 logger.info("Code:"+countryDetails.getCode());  
		 logger.info("Name:"+countryDetails.getName());  
		 logger.info("Region:"+countryDetails.getRegion());  

	}
}
