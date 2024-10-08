package org.jsp.emp.controller;

import org.jsp.emp.entity.Employee;
import org.jsp.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/employees")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	
	@PostMapping
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee)
	{
		return service.saveEmployee(employee);
	}
	
	@PutMapping
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee)
	{
		return service.updateEmployee(employee);
	}
	@GetMapping
	public ResponseEntity<?> findAllEmployees()
	{
		return service.findAllEmployees();
	}
	@GetMapping(value ="/{id}")
	public ResponseEntity<?> findEmployeeById(@PathVariable int id)
	{
		return service.findEmployeeById(id);
	}
	@GetMapping(value ="/name/{name}")
	public ResponseEntity<?> findEmployeesByname(@PathVariable String name)
	{
		return service.findEmployeeByName(name);
	}
	@GetMapping(value ="/{email}/{password}")
	public ResponseEntity<?> findEmployeesByEmailAndPassword(@PathVariable String email,@PathVariable String password)
	{
		return service.findEmployeeByEmailandPassword(email, password);
	}
	@DeleteMapping(value ="/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable int id)
	{
		return service.deleteEmployeeById(id);
	}
	@PatchMapping(value = "/active/{id}")
	public ResponseEntity<?> setStatusToActive(@PathVariable int id)
	{
		return service.setStatusToActive(id);
	}
	@PatchMapping(value = "/inactive/{id}")
	public ResponseEntity<?> setStatusToInActive(@PathVariable int id)
	{
		return service.setStatusToInActive(id);
	}

}
