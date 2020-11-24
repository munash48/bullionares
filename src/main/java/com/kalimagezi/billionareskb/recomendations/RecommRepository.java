package com.kalimagezi.billionareskb.recomendations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RecommRepository extends CrudRepository<Recommendations, Integer> {

	ArrayList<Recommendations> findTop10ByJaidOrderByCreateDateDesc(int id);

	

}
