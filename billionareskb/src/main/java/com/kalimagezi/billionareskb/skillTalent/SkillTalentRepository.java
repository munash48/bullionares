package com.kalimagezi.billionareskb.skillTalent;

import org.springframework.data.repository.CrudRepository;

public interface SkillTalentRepository extends CrudRepository<SkillTalent, Integer> {

	SkillTalent findByUid(int id);

}
