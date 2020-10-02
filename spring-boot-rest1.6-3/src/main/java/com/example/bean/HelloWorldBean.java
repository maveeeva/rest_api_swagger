package com.example.bean;

public class HelloWorldBean {
	String message;

	public HelloWorldBean(String string) {
		this.message = string;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message= %s]" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
