package com.springmvc.restful.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.restful.dao.DepartmentDao;
import com.springmvc.restful.dao.EmployeeDao;
import com.springmvc.restful.entity.Department;
import com.springmvc.restful.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private DepartmentDao departmentDao;
	private static Map<Integer, Employee> employees = null;
	
	static {
		employees = new HashMap<Integer, Employee>();
		employees.put(1101, new Employee(1101, "Andy", 21, 1, "Andy@springMvc.com", new Department(101, "D-AA")));
		employees.put(1102, new Employee(1102, "Bert", 22, 0, "Bert@springMvc.com", new Department(102, "D-BB")));
		employees.put(1103, new Employee(1103, "Cedric", 23, 1, "Cedric@springMvc.com", new Department(103, "D-CC")));
		employees.put(1104, new Employee(1104, "Dana", 24, 0, "Dana@springMvc.com", new Department(104, "D-DD")));
		employees.put(1105, new Employee(1105, "Keith", 25, 1, "Keith@springMvc.com", new Department(105, "D-EE")));
		employees.put(1106, new Employee(1106, "Enoch", 26, 0, "Enoch@springMvc.com", new Department(106, "D-FF")));
	}
	
	private static Integer initId = 1007;
	
	@Override
	public void save(Employee employee) {
		if(employee.getId() == null) {
			employee.setId(initId++);
		}
		
		employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}

	@Override
	public Collection<Employee> getgetEmployees() {
		return employees.values();
	}

	@Override
	public Employee getEmployee(Integer id) {
		return employees.get(id);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employees.remove(id);
	}

}
