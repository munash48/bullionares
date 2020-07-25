package com.kalimagezi.billionareskb.opinion;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

public interface OpinionRepository extends CrudRepository<Opinion, Integer> {

	ArrayList<Opinion> findTop10ByAidOrderByCreateDateDesc(int id);

}
