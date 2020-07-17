package com.kalimagezi.billionareskb.skillTalent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SkillTalentService {

	
	@Autowired
	private SkillTalentRepository skillTalentRepository;

	public void addSkillTalent(SkillTalent skillTalent) {

		skillTalentRepository.save(skillTalent);
	}

	public Optional<SkillTalent> getSkillTalent(int id) {

		return skillTalentRepository.findById(id);

	}

	public List<SkillTalent> getAllSkillTalents() {

		List<SkillTalent> skillTalents = new ArrayList<>();
		skillTalentRepository.findAll().forEach(skillTalents::add);
		return skillTalents;

	}

	public void updateSkillTalent(SkillTalent skillTalent) {

		skillTalentRepository.save(skillTalent);
	}

	public void deleteSkillTalent(int id) {
		skillTalentRepository.deleteById(id);

	}

	public SkillTalent getUSkillTalent(int id) {
		// TODO Auto-generated method stub
		return skillTalentRepository.findByUid(id);
	}

}
