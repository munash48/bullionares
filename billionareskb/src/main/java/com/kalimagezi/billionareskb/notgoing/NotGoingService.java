package com.kalimagezi.billionareskb.notgoing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalimagezi.billionareskb.notgoing.NotGoing;
import com.kalimagezi.billionareskb.notgoing.NotGoingRepository;

@Service
public class NotGoingService {
	@Autowired
	private NotGoingRepository notGoingRepository;

	public void addNotGoing(NotGoing notGoing) {

		notGoingRepository.save(notGoing);
	}

	public Optional<NotGoing> getNotGoing(int id) {

		return notGoingRepository.findById(id);

	}

	public List<NotGoing> getAllNotGoings() {

		List<NotGoing> notGoings = new ArrayList<>();
		notGoingRepository.findAll().forEach(notGoings::add);
		return notGoings;

	}

	public void updateNotGoing(NotGoing notGoing) {

		notGoingRepository.save(notGoing);
	}

	public void deleteNotGoing(int id) {
		notGoingRepository.deleteById(id);

	}
	public List<NotGoing> getAllNotGoingsByUid(int uid) {
		// TODO Auto-generated method stub
		return notGoingRepository.findAllByUid(uid);
	}

	public List<NotGoing> getAllNotGoingsByEid(Integer eid) {
		// TODO Auto-generated method stub
		return notGoingRepository.findAllByEid(eid);
	}



}
