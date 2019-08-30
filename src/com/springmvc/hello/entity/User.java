package com.springmvc.hello.entity;


public class User {
	
	private int userId;
	private String username;
	private String password;
	private String email;
	private Address address;
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", address=" + address + "]";
	}
	
	public User(int userId, String username, String password, String email, Address address) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
	}

	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
