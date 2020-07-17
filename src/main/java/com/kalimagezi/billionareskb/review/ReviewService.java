package com.kalimagezi.billionareskb.review;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reportRepository;

	public void addReview(Review report) {

		reportRepository.save(report);
	}

	public Optional<Review> getReview(int id) {

		return reportRepository.findById(id);

	}

	public List<Review> getAllReviews() {

		List<Review> reviews = new ArrayList<>();
		reportRepository.findAll().forEach(reviews::add);
		return reviews;

	}

	public void updateReview(Review report) {

		reportRepository.save(report);
	}

	public void deleteReview(int id) {
		reportRepository.deleteById(id);

	}

	public List<Review> getAReviews(int id) {
		// TODO Auto-generated method stub
		return reportRepository.findByAid(id);
	}


}
