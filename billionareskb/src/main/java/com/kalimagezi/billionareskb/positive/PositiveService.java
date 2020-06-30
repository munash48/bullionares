package com.kalimagezi.billionareskb.positive;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalimagezi.billionareskb.positive.Positive;
import com.kalimagezi.billionareskb.positive.PositiveRepository;
@Service
public class PositiveService {
	@Autowired
	private PositiveRepository positiveRepository;

	public void addPositive(Positive positive) {

		positiveRepository.save(positive);
	}

	public Optional<Positive> getPositive(int id) {

		return positiveRepository.findById(id);

	}

	public List<Positive> getAllPositives() {

		List<Positive> positives = new ArrayList<>();
		positiveRepository.findAll().forEach(positives::add);
		return positives;

	}

	public void updatePositive(Positive positive) {

		positiveRepository.save(positive);
	}

	public void deletePositive(int id) {
		positiveRepository.deleteById(id);

	}
	public List<Positive> getAllPositivesByUid(int uid) {
		// TODO Auto-generated method stub
		return positiveRepository.findAllByUid(uid);
	}

	public List<Positive> getAllPositivesByAid(Integer aid) {
		// TODO Auto-generated method stub
		return positiveRepository.findAllByAid(aid);
	}


}
