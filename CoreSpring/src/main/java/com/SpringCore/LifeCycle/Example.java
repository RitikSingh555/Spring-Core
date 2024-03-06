package com.SpringCore.LifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Example {
	
	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Example [subject=" + subject + "]";
	}
	
	@PostConstruct
	public void start()
	{
		System.out.println("Starting Method");
	}
	@PreDestroy
	public void End() {
		System.out.println("Ending Method");
	}

}
