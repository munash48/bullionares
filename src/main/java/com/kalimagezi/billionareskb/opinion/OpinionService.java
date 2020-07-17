package com.kalimagezi.billionareskb.opinion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OpinionService {
	
	@Autowired
	private OpinionRepository opinionRepository;

	public void addOpinion(Opinion opinion) {

		opinionRepository.save(opinion);
	}

	public Optional<Opinion> getOpinion(int id) {

		return opinionRepository.findById(id);

	}

	public List<Opinion> getAllOpinions() {

		List<Opinion> opinions = new ArrayList<>();
		opinionRepository.findAll().forEach(opinions::add);
		return opinions;

	}

	public void updateOpinion(Opinion opinion) {

		opinionRepository.save(opinion);
	}

	public void deleteOpinion(int id) {
		opinionRepository.deleteById(id);

	}

	public ArrayList<Opinion> getOpinionsByAid(int id) {
		// TODO Auto-generated method stub
		return opinionRepository.findTop10ByAidOrderByCreateDateDesc(id);
	}


}
