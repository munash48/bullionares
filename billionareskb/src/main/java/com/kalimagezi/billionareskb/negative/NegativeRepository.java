package com.kalimagezi.billionareskb.negative;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NegativeRepository extends CrudRepository<Negative, Integer>{

	List<Negative> findAllByUid(int uid);

	List<Negative> findAllByAid(Integer aid);

}

