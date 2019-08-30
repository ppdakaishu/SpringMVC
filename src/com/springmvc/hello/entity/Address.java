package com.springmvc.hello.entity;

public class Address {

	private String city;
	private String province;
	
	@Override
	public String toString() {
		return "Address [city=" + city + ", province=" + province + "]";
	}
	
	public Address() {
		super();
	}

	public Address(String city, String province) {
		super();
		this.city = city;
		this.province = province;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
}
