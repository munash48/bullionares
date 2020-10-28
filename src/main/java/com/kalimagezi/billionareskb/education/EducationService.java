package com.kalimagezi.billionareskb.education;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EducationService {

	@Autowired
	private EducationRepository educationRepository;

	public String addEducation(Education education) {
		
		JSONObject jsonObject = new JSONObject();

		educationRepository.save(education);
		try {
			jsonObject.put("message", education.getAward() +" Updated successfully");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
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
