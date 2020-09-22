package com.kalimagezi.billionareskb.education;

import org.springframework.data.repository.CrudRepository;

public interface EducationRepository extends CrudRepository<Education, Integer> {

	Education findByUid(int id);

}
