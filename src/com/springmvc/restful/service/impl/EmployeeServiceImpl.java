package com.springmvc.restful.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springmvc.restful.dao.EmployeeDao;
import com.springmvc.restful.entity.Employee;
import com.springmvc.restful.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeDao employeeDao;
	
	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public Collection<Employee> getEmployees() {
		return employeeDao.getgetEmployees();
	}

	@Override
	public Employee getEmployee(Integer id) {
		return employeeDao.getEmployee(id);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeDao.deleteEmployee(id);
	}

}
