package com.kalimagezi.billionareskb.career;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CareerService {

	
	@Autowired
	private CareerRepository careerRepository;

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

	public void updateCareer(Career career) {

		careerRepository.save(career);
	}

	public void deleteCareer(int id) {
		careerRepository.deleteById(id);

	}

	public Career getUCareer(int id) {
		// TODO Auto-generated method stub
		return careerRepository.findByUid(id);
	}

}
