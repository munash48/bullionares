package com.kalimagezi.billionareskb.vote;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Integer> {


	List<Vote> findAllByUid(int uid);

	List<Vote> findAllByAid(Integer aid);

}
