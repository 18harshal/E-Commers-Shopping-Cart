package com.company.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.company.exception.ResourceNotFoundException;
import com.company.model.Employee;
import com.company.repository.EmployeeRepository;
import com.company.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
 
	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
		
//		 Optional<Employee> employee= employeeRepository.findById(id);
//		if( employee.isPresent()) {
//			return  employee.get();
//		} else {
//			throw new ResourceNotFoundException("Employee","Id", id);
//		}
		
		// using lamda Expression
		
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		
	}


	@Override
	public Employee updatEmployee(Employee employee, long id) {
		// we need to check  whether employee with given  id is  exist in DB or not !!
		
		Employee existemployee= employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		
		existemployee.setFirstname(employee.getFirstname());
		existemployee.setLastname(employee.getLastname());
		existemployee.setEmail(employee.getEmail());
		
		// save existing employee
		employeeRepository.save(existemployee);
		return existemployee;
	}


	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		// Check whether Employee Exist or not 
				 employeeRepository.findById(id). orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
				
				employeeRepository.deleteById(id);
		
	}

}
