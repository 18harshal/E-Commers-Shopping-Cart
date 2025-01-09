package com.company.service;

import java.util.List;

import com.company.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updatEmployee(Employee employee, long id);
	 void deleteEmployee( Long id);
	

}
