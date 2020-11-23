package com.kalimagezi.billionareskb.recomendations;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

public interface RecommRepository extends CrudRepository<Recommendations, Integer> {

	ArrayList<Recommendations> findTop10ByAidOrderByCreateDateDesc(int id);

}
