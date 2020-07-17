package com.kalimagezi.billionareskb.going;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GoingRepository extends CrudRepository<Going, Integer> {

	List<Going> findAllByUid(int uid);

	List<Going> findAllByEid(Integer eid);

	Going findByEid(int eid);

}
