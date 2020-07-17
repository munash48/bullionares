package com.kalimagezi.billionareskb.education;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EducationService {

	@Autowired
	private EducationRepository educationRepository;

	public void addEducation(Education education) {

		educationRepository.save(education);
	}

	public Optional<Education> getEducation(int id) {

		return educationRepository.findById(id);

	}

	public List<Education> getAllEducations() {

		List<Education> educations = new ArrayList<>();
		educationRepository.findAll().forEach(educations::add);
		return educations;

	}

	public void updateEducation(Education education) {

		educationRepository.save(education);
	}

	public void deleteEducation(int id) {
		educationRepository.deleteById(id);

	}

	public Education getUEducation(int id) {
		// TODO Auto-generated method stub
		return educationRepository.findByUid(id);
	}

}
