package com.spring.CollectionUsingBean;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cglib.proxy.Dispatcher;

public class QuestionAnswer implements InitializingBean,DisposableBean{

	private String question;
	private List<String> options;
	private Map<String,String> sampleMap;
	
	public QuestionAnswer() {
		System.out.println("Constructor Invoked");
	}
	
	public QuestionAnswer(String question, List<String> options) {
		super();
		this.question = question;
		this.options = options;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	
	
	public Map<String, String> getSampleMap() {
		return sampleMap;
	}
	public void setSampleMap(Map<String, String> sampleMap) {
		this.sampleMap = sampleMap;
	}
	@Override
	public String toString() {
		return "question=" + question + "\n options=" + options + "\n sampleMap=" + sampleMap + "]";
	}

	@Override
	public void destroy() throws Exception {

		System.out.println("Destroyed");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initialized");
	}
}
