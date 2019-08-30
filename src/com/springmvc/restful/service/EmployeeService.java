package com.springmvc.restful.service;

import java.util.Collection;

import com.springmvc.restful.entity.Employee;

public interface EmployeeService {

	public void save(Employee employee);
	
	public Collection<Employee> getEmployees();
	
	public Employee getEmployee(Integer id);
	
	public void deleteEmployee(Integer id);
	
}
