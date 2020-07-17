package com.kalimagezi.billionareskb.counter;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CounterRepository extends CrudRepository<Counter, Integer> {

	Counter findByUid(int id);

	List<Counter> findTop10ByOrderByTotalDesc();

	Counter findTopByCidOrderByTotalDesc(int catid);

	Counter findTopByOrderByTotalDesc();

	List<Counter> findTop10ByCidOrderByTotalDesc(int catid);


}
