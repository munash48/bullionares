package com.kalimagezi.billionareskb.analysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AnalysisService {

	@Autowired
	private AnalysisRepository analysisRepository;

	public void addAnalysis(Analysis analysis) {

		analysisRepository.save(analysis);
	}

	public Optional<Analysis> getAnalysis(int id) {

		return analysisRepository.findById(id);

	}

	public List<Analysis> getAllAnalysiss() {

		List<Analysis> analysiss = new ArrayList<>();
		analysisRepository.findAll().forEach(analysiss::add);
		return analysiss;

	}

	public void updateAnalysis(Analysis analysis) {

		analysisRepository.save(analysis);
	}

	public void deleteAnalysis(int id) {
		analysisRepository.deleteById(id);

	}

	public List<Analysis> getAnalysissByEid(int id) {
		// TODO Auto-generated method stub
		return analysisRepository.findByEid(id);
	}

	
}
