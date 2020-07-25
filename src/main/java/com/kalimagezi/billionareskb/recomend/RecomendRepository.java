package com.kalimagezi.billionareskb.recomend;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RecomendRepository extends CrudRepository<Recomend, Integer> {

	List<Recomend> findAllByUid(int uid);

	List<Recomend> findAllByJaid(Integer jaid);



}

