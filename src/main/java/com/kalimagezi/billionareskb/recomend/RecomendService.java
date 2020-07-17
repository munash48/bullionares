package com.kalimagezi.billionareskb.recomend;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalimagezi.billionareskb.recomend.Recomend;
import com.kalimagezi.billionareskb.recomend.RecomendRepository;

@Service
public class RecomendService {
	@Autowired
	private RecomendRepository recomendRepository;

	public void addRecomend(Recomend recomend) {

		recomendRepository.save(recomend);
	}

	public Optional<Recomend> getRecomend(int id) {

		return recomendRepository.findById(id);

	}

	public List<Recomend> getAllRecomends() {

		List<Recomend> recomends = new ArrayList<>();
		recomendRepository.findAll().forEach(recomends::add);
		return recomends;

	}

	public void updateRecomend(Recomend recomend) {

		recomendRepository.save(recomend);
	}

	public void deleteRecomend(int id) {
		recomendRepository.deleteById(id);

	}
	public List<Recomend> getAllRecomendsByUid(int uid) {
		// TODO Auto-generated method stub
		return recomendRepository.findAllByUid(uid);
	}

	public List<Recomend> getAllRecomendsByJaid(Integer jaid) {
		// TODO Auto-generated method stub
		return recomendRepository.findAllByJaid(jaid);
	}




}
