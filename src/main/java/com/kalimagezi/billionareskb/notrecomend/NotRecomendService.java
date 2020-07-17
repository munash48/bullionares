package com.kalimagezi.billionareskb.notrecomend;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class NotRecomendService {

	
	@Autowired
	private NotRecomendRepository notRecomendRepository;

	public void addNotRecomend(NotRecomend notRecomend) {

		notRecomendRepository.save(notRecomend);
	}

	public Optional<NotRecomend> getNotRecomend(int id) {

		return notRecomendRepository.findById(id);

	}

	public List<NotRecomend> getAllNotRecomends() {

		List<NotRecomend> notRecomends = new ArrayList<>();
		notRecomendRepository.findAll().forEach(notRecomends::add);
		return notRecomends;

	}

	public void updateNotRecomend(NotRecomend notRecomend) {

		notRecomendRepository.save(notRecomend);
	}

	public void deleteNotRecomend(int id) {
		notRecomendRepository.deleteById(id);

	}
	public List<NotRecomend> getAllNotRecomendsByUid(int uid) {
		// TODO Auto-generated method stub
		return notRecomendRepository.findAllByUid(uid);
	}

	public List<NotRecomend> getAllNotRecomendsByJaid(Integer jaid) {
		// TODO Auto-generated method stub
		return notRecomendRepository.findAllByJaid(jaid);
	}


}
