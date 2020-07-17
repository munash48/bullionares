package com.kalimagezi.billionareskb.counter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CounterService {

	@Autowired
	private CounterRepository counterRepository;

	public void addCounter(Counter counter) {

		counterRepository.save(counter);
	}

	public Optional<Counter> getCounter(int id) {

		return counterRepository.findById(id);

	}

	public List<Counter> getAllCounters() {

		List<Counter> counters = new ArrayList<>();
		counterRepository.findAll().forEach(counters::add);
		return counters;

	}

	public void updateCounter(Counter counter) {

		counterRepository.save(counter);
	}

	public void deleteCounter(int id) {
		counterRepository.deleteById(id);

	}

	public Counter getUCounter(int id) {
		// TODO Auto-generated method stub
		return counterRepository.findByUid(id);
	}

	public Counter getTopCounter() {
		// TODO Auto-generated method stub
		return counterRepository.findTopByOrderByTotalDesc();
	}

	public Counter getTopCatCounter(int catid) {
		// TODO Auto-generated method stub
		return counterRepository.findTopByCidOrderByTotalDesc(catid);
	}

	public List<Counter> getTop10CatCounter(int catid) {
		// TODO Auto-generated method stub
		 return counterRepository.findTop10ByCidOrderByTotalDesc(catid);
	}

	public List<Counter> getTop10Counter() {
		// TODO Auto-generated method stub
		return counterRepository.findTop10ByOrderByTotalDesc();
	}

	

}
