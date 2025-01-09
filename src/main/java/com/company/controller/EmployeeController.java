package com.company.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Employee;
import com.company.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	 @PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);	
		
	} 
	  @GetMapping
	  public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
		  
	  }
          // get employee by id rest ApI
	  //http://localhost:8084/api/employees/1
	  @GetMapping("{id}")
	  public ResponseEntity<Employee> getEmpployeeByID(@PathVariable("id") long employeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
		  
	  }
	  // update employee   http://localhost:8084/api/employees/1
	  
	  @PutMapping({"id"})
	  public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
		  return new ResponseEntity<Employee>(employeeService.updatEmployee(employee,id), HttpStatus.OK);
		   
	  } 
	  
	  // Build Delete Employee RestApi
	  @DeleteMapping({"id"})
	  public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		  //Delete Employee DataBase
		  employeeService.deleteEmployee(id);
		  return new ResponseEntity<String>("Employee Deleted Successfully !!.", HttpStatus.OK);
	  }

}
