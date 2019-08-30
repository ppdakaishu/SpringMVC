package com.springmvc.restful.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springmvc.restful.dao.DepartmentDao;
import com.springmvc.restful.entity.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	private static Map<Integer, Department> departments = null;
	
	static {
		departments = new HashMap<Integer, Department>();
		departments.put(101, new Department(101, "D-AA"));
		departments.put(102, new Department(102, "D-BB"));
		departments.put(103, new Department(103, "D-CC"));
		departments.put(104, new Department(104, "D-DD"));
		departments.put(105, new Department(105, "D-EE"));
		departments.put(106, new Department(106, "D-FF"));
	}

	@Override
	public Collection<Department> getDepartments() {
		return departments.values();
	}

	@Override
	public Department getDepartment(Integer id) {
		return departments.get(id);
	}
	
}
