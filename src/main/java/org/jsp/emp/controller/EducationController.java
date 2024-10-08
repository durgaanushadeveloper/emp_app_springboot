package org.jsp.emp.controller;

import org.jsp.emp.entity.Education;
import org.jsp.emp.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/education")
public class EducationController {
	
	@Autowired
	EducationService service;
	
	@PostMapping
	public ResponseEntity<?> saveEducation(@RequestBody Education education)
	{
		return service.saveEducation(education);
	}
	
	@GetMapping
	public ResponseEntity<?> findEducation()
	{
		return service.findEducation();
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findEducationById(@PathVariable int id)
	{
		return service.findEducationById(id);
	}
	
	
	@PutMapping
	public ResponseEntity<?> updateEducation(@RequestBody Education education)
	{
		return service.updateEducation(education);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEducationById(@PathVariable int id)
	{
		service.deleteEducationById(id);
	}

}
