package com.kalimagezi.billionareskb.notgoing;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NotGoingRepository extends CrudRepository<NotGoing, Integer> {

	List<NotGoing> findAllByUid(int uid);

	List<NotGoing> findAllByEid(Integer eid);



}
