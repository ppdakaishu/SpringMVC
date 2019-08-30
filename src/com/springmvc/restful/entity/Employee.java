package com.springmvc.restful.entity;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Employee {

	private Integer id;
	@NotEmpty
	private String employeeName;
	@Range(min = 18, max = 60, message = "Age must be between 18 and 60 years old")
	private Integer age;
	private Integer gender; //0 -> male [ 男 ]	| 1 -> female [ 女 ]
	@Email(message = "illegal email address")
	private String email;
	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;
	@NumberFormat(pattern="#,###,###.#")
	private float salary;
	private Department department;
	
	public Employee() {
		
	}

	public Employee(Integer id, String employeeName, Integer age, Integer gender, String email,
			Department department) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName + ", age=" + age + ", gender=" + gender
				+ ", email=" + email + ", birth=" + birth + ", salary=" + salary + ", department=" + department + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
