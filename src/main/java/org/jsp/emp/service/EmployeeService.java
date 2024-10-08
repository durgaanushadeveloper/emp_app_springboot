package org.jsp.emp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.dao.EmployeeDao;
import org.jsp.emp.entity.Employee;
import org.jsp.emp.exceptionclasses.InvalidCredentialsException;
import org.jsp.emp.exceptionclasses.InvalidEmployeeIdException;
import org.jsp.emp.exceptionclasses.NoActiveEmployeeFoundException;
import org.jsp.emp.exceptionclasses.NoEmployeeFoundException;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.jsp.emp.util.EmployeeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;
	public ResponseEntity<?> saveEmployee(Employee employee)
	{
		employee.setStatus(EmployeeStatus.IN_ACTIVE);
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("employee saved successfully......").body(dao.saveEmployye(employee)).build());
	}
	public ResponseEntity<?> updateEmployee(Employee employee)
	{		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("employee updated successfully").body(dao.updateEmployee(employee)).build());
	}
	public ResponseEntity<?> findEmployeeById(int id)
	{
		Optional<Employee> optional=dao.findEmployeeById(id);
		if(optional.isEmpty())
			throw  InvalidEmployeeIdException.builder().message("invalid employee id unable to find").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee found successfully..............").body(optional.get()).build());
	}
		
	public ResponseEntity<?> findAllEmployees()
	{
		List<Employee> employees=dao.findAllActiveEmployees();
		if(employees.isEmpty())
			throw NoActiveEmployeeFoundException.builder().message("no emploee found").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Employees successfully..............").body(employees).build());
	}
	public ResponseEntity<?> deleteEmployeeById(int id)
	{	
		Optional<Employee> optional=dao.findEmployeeById(id);
		if(optional.isEmpty())
			throw  InvalidEmployeeIdException.builder().message("invalid employee id unable to delete").build();
		dao.deleteEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("employee deleted successfully.").body("employee deleted").build());
		
	}
	public ResponseEntity<?> findEmployeeByEmailandPassword(String email,String password)
	{
		Optional<Employee> optional=dao.findEmployeeByEmailAndPassword(email,password);
		if(optional.isEmpty())
			throw InvalidCredentialsException.builder().message("Invalid email or password...").build();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value()).message("verification successfull..").body(optional.get()).build());
	}
	
	public ResponseEntity<?> findEmployeeByName(String name)
	{
		List<Employee> employees=dao.findEmployeeByName(name);
		if(employees.isEmpty())
			throw NoEmployeeFoundException.builder().message("No matching employee found for the requested name..").build();
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value()).message("Employee found successfully").body(employees).build());
	}
	public ResponseEntity<?> setStatusToActive(int id) {
		Optional<Employee> optional=dao.findEmployeeById(id);
		if(optional.isEmpty())
					throw InvalidEmployeeIdException.builder().message("invalid employee id unable to set status to active").build();
		Employee employee=optional.get();
		employee.setStatus(EmployeeStatus.ACTIVE);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).body(dao.updateEmployee(employee)).message("employee set to Active successfully............").build());
	}
	public ResponseEntity<?> setStatusToInActive(int id) {
		Optional<Employee> optional=dao.findEmployeeById(id);
		if(optional.isEmpty())
					throw InvalidEmployeeIdException.builder().message("invalid employee id unable to set status as IN_ACTIVE").build();
		Employee employee=optional.get();
		employee.setStatus(EmployeeStatus.IN_ACTIVE);		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).body(dao.updateEmployee(employee)).message("Employee status is set to IN_Active").build());
	}
}
