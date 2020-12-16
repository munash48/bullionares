package com.kalimagezi.billionareskb.jobadd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JobaddService {

	
	@Autowired
	private JobaddRepository jobaddRepository;

	public void addJobadd(Jobadd jobadd) {

		jobaddRepository.save(jobadd);
	}

	public Optional<Jobadd> getJobadd(int id) {

		return jobaddRepository.findById(id);

	}

	public List<Jobadd> getAllJobadds() {

		List<Jobadd> jobadds = new ArrayList<>();
		jobaddRepository.findAll().forEach(jobadds::add);
		return jobadds;

	}

	public void updateJobadd(Jobadd jobadd) {

		jobaddRepository.save(jobadd);
	}

	public void deleteJobadd(int id) {
		jobaddRepository.deleteById(id);

	}

	public List<Jobadd> getCatJobadd(int catid) {
		// TODO Auto-generated method stub
		return jobaddRepository.findTop10ByCidOrderByAddDateDesc(catid);
	}

}
