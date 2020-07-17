package com.kalimagezi.billionareskb.negative;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalimagezi.billionareskb.negative.Negative;
import com.kalimagezi.billionareskb.negative.NegativeRepository;

@Service
public class NegativeService {
	@Autowired
	private NegativeRepository negativeRepository;

	public void addNegative(Negative negative) {

		negativeRepository.save(negative);
	}

	public Optional<Negative> getNegative(int id) {

		return negativeRepository.findById(id);

	}

	public List<Negative> getAllNegatives() {

		List<Negative> negatives = new ArrayList<>();
		negativeRepository.findAll().forEach(negatives::add);
		return negatives;

	}

	public void updateNegative(Negative negative) {

		negativeRepository.save(negative);
	}

	public void deleteNegative(int id) {
		negativeRepository.deleteById(id);

	}
	public List<Negative> getAllNegativesByUid(int uid) {
		// TODO Auto-generated method stub
		return negativeRepository.findAllByUid(uid);
	}

	public List<Negative> getAllNegativesByAid(Integer aid) {
		// TODO Auto-generated method stub
		return negativeRepository.findAllByAid(aid);
	}


}
