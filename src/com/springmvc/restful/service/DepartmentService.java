package com.springmvc.restful.service;

import java.util.Collection;

import com.springmvc.restful.entity.Department;

public interface DepartmentService {

	public Collection<Department> getDepartments();
	
	public Department getDepartment(Integer id);
	
}
