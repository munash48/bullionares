package com.kalimagezi.billionareskb.positive;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PositiveRepository extends CrudRepository<Positive, Integer>{

	List<Positive> findAllByUid(int uid);

	List<Positive> findAllByAid(Integer aid);

}
