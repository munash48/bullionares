package com.kalimagezi.billionareskb.jobadd;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JobaddRepository extends CrudRepository<Jobadd, Integer> {

	List<Jobadd> findTop10ByCid(int catid);

}
