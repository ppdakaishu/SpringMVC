package com.springmvc.restful.dao;

import java.util.Collection;

import com.springmvc.restful.entity.Employee;

public interface EmployeeDao {

	public void save(Employee employee);
	
	public Collection<Employee> getgetEmployees();
	
	public Employee getEmployee(Integer id);
	
	public void deleteEmployee(Integer id);
	
}
