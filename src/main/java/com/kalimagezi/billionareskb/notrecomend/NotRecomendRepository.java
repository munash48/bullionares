package com.kalimagezi.billionareskb.notrecomend;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface NotRecomendRepository extends CrudRepository<NotRecomend, Integer>  {
	List<NotRecomend> findAllByUid(int uid);

	List<NotRecomend> findAllByJaid(Integer jaid);

}
