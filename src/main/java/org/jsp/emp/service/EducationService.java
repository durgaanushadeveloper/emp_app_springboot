package org.jsp.emp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.dao.EducationDao;
import org.jsp.emp.entity.Education;
import org.jsp.emp.exceptionclasses.InvalidEducationIdException;
import org.jsp.emp.exceptionclasses.NoEducationFoundException;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EducationService {
 
	@Autowired
	private EducationDao dao;
	public ResponseEntity<?> saveEducation(Education education) {
			return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("education saved successfully..").body(dao.saveEducation(education)).build());
	}
	public ResponseEntity<?> findEducation() {
		List<Education> education=dao.findEducations();
		if(education.isEmpty())
			throw new NoEducationFoundException();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All education details fetched").body(education).build());
	}
	public ResponseEntity<?> updateEducation(Education education) {
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("education updated successfully..").body(dao.updateEducation(education)).build());
	}
	public ResponseEntity<?> deleteEducationById(int id) {
		Optional<Education> optional=dao.findEducationById(id);
		if(optional.isEmpty())
			throw InvalidEducationIdException.builder().message("Unable to delete").build();			
		dao.deleteEducationById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).body("Education deleted successfully").build());
	}
	public ResponseEntity<?> findEducationById(int id) {
		Optional<Education> optional=dao.findEducationById(id);
		if(optional.isEmpty())
			throw InvalidEducationIdException.builder().message("Invalid id").build();
		Education education=optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).body(education).message("Education verified successfully....").build());
	}
	
	

}
