package com.springmvc.restful.entity;

public class Person {

	private String name;
	private String password;
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", password=" + password + "]";
	}
	
	public Person() {
		super();
	}

	public Person(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
