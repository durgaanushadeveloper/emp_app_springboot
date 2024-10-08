package org.jsp.emp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.entity.Education;
import org.jsp.emp.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EducationDao {
	
	@Autowired
	private EducationRepository repository;

	public Education saveEducation(Education education) {
		return repository.save(education);
	}
	
	public List<Education> findEducations()
	{
		return repository.findAll();
	}

	public Education updateEducation(Education education) {
		return repository.save(education);
	}

	public void deleteEducationById(int id) {
		repository.deleteById(id);
		
	}

	public Optional<Education> findEducationById(int id) {
		return repository.findById(id);
	}

}
