package com.springmvc.restful.dao;

import java.util.Collection;

import com.springmvc.restful.entity.Department;

public interface DepartmentDao {

	public Collection<Department> getDepartments();
	
	public Department getDepartment(Integer id);
	
}
