package com.kalimagezi.billionareskb.education;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;


@Service
public class EducationService {

	@Autowired
	private EducationRepository educationRepository;
	@Autowired
	private CounterService counterService;

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

	public String updateEducation(Education education) {
		JSONObject jsonObject = new JSONObject();

		educationRepository.save(education);
		Counter counter =counterService.getUCounter(education.getUid());
		try {
			jsonObject.put("message", education.getAward() +" Updated successfully");
			jsonObject.put("noVotes", counter.getNoVotes());
			jsonObject.put("noTVotes", counter.getTotal());
			jsonObject.put("newEduc", education.getAward());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}

	public void deleteEducation(int id) {
		educationRepository.deleteById(id);

	}

	public Education getUEducation(int id) {
		// TODO Auto-generated method stub
		return educationRepository.findByUid(id);
	}

}
