package com.kalimagezi.billionareskb.career;

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
public class CareerService {

	
	@Autowired
	private CareerRepository careerRepository;
	@Autowired
	private CounterService counterService;

	public void addCareer(Career career) {
		

		careerRepository.save(career);
		
	}

	public Optional<Career> getCareer(int id) {

		return careerRepository.findById(id);

	}

	public List<Career> getAllCareers() {

		List<Career> careers = new ArrayList<>();
		careerRepository.findAll().forEach(careers::add);
		return careers;

	}

	public String updateCareer(Career career) {
		JSONObject jsonObject = new JSONObject();

		careerRepository.save(career);
		Counter counter =counterService.getUCounter(career.getUid());
		try {
			jsonObject.put("message", career.getJobTitle()+" Updated successfully");
			jsonObject.put("noVotes", counter.getNoVotes());
			jsonObject.put("noTVotes", counter.getTotal());
			jsonObject.put("newJob", career.getJobTitle()+", <br>"+career.getSpecialization() );
			jsonObject.put("newCar", career.getDescription() );
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}

	public void deleteCareer(int id) {
		careerRepository.deleteById(id);

	}

	public Career getUCareer(int id) {
		// TODO Auto-generated method stub
		return careerRepository.findByUid(id);
	}

}
