package com.kalimagezi.billionareskb.career;

import org.springframework.data.repository.CrudRepository;

public interface CareerRepository extends CrudRepository<Career, Integer> {

	Career findByUid(int id);

}
