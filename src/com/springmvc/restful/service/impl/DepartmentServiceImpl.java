package com.springmvc.restful.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springmvc.restful.dao.DepartmentDao;
import com.springmvc.restful.entity.Department;
import com.springmvc.restful.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Resource
	private DepartmentDao departmentDao;
	
	@Override
	public Collection<Department> getDepartments() {
		return departmentDao.getDepartments();
	}

	@Override
	public Department getDepartment(Integer id) {
		return departmentDao.getDepartment(id);
	}

}
