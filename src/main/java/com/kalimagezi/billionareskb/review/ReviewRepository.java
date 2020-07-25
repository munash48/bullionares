package com.kalimagezi.billionareskb.review;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Integer>{

	List<Review> findByAid(int id);

}
