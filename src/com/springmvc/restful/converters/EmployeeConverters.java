package com.springmvc.restful.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.springmvc.restful.entity.Department;
import com.springmvc.restful.entity.Employee;
import com.springmvc.restful.service.DepartmentService;

@Component
public class EmployeeConverters implements Converter<String, Employee> {

	@Autowired
	private DepartmentService departmentService;
	
	@Override
	public Employee convert(String employeeStr) {
		System.out.println("employeeStr : " + employeeStr);
		if(employeeStr != null) {
			String[] vals = employeeStr.split(",");
			if(vals != null && vals.length == 5) {
				Employee employee = new Employee();
				employee.setEmployeeName(vals[0]);
				employee.setAge(Integer.parseInt(vals[1]));
				employee.setGender(Integer.parseInt(vals[2]));
				employee.setEmail(vals[3]);
				Department department = departmentService.getDepartment(Integer.parseInt(vals[4]));
				employee.setDepartment(department);
				return employee;
			}
		}
		return null;
	}
}
