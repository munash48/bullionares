package com.kalimagezi.billionareskb.recomendations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecommendationsService {
	
	@Autowired
	private RecommRepository recommendationRepository;

	public void addRecommendations(Recommendations recommendation) {

		recommendationRepository.save(recommendation);
	}

	public Optional<Recommendations> getRecommendations(int id) {

		return recommendationRepository.findById(id);

	}

	public List<Recommendations> getAllRecommendationss() {

		List<Recommendations> recommendations = new ArrayList<>();
		recommendationRepository.findAll().forEach(recommendations::add);
		return recommendations;

	}

	public void updateRecommendations(Recommendations recommendation) {

		recommendationRepository.save(recommendation);
	}

	public void deleteRecommendations(int id) {
		recommendationRepository.deleteById(id);

	}

	public ArrayList<Recommendations> getRecommendationssByAid(int id) {
		// TODO Auto-generated method stub
		return recommendationRepository.findTop10ByAidOrderByCreateDateDesc(id);
	}


}
