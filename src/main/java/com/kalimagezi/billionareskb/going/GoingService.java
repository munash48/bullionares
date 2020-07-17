package com.kalimagezi.billionareskb.going;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalimagezi.billionareskb.going.Going;
import com.kalimagezi.billionareskb.going.GoingRepository;

@Service
public class GoingService {
	
	@Autowired
	private GoingRepository goingRepository;

	public void addGoing(Going going) {

		goingRepository.save(going);
	}

	public Optional<Going> getGoing(int id) {

		return goingRepository.findById(id);

	}

	public List<Going> getAllGoings() {

		List<Going> goings = new ArrayList<>();
		goingRepository.findAll().forEach(goings::add);
		return goings;

	}

	public void updateGoing(Going going) {

		goingRepository.save(going);
	}

	public void deleteGoing(int id) {
		goingRepository.deleteById(id);

	}
	public List<Going> getAllGoingsByUid(int uid) {
		// TODO Auto-generated method stub
		return goingRepository.findAllByUid(uid);
	}

	public List<Going> getAllGoingsByEid(Integer eid) {
		// TODO Auto-generated method stub
		return goingRepository.findAllByEid(eid);
	}

	public Going getEGoing(int eid) {
		// TODO Auto-generated method stub
		return goingRepository.findByEid(eid);
	}


}
