package com.kalimagezi.billionareskb.skillTalent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;



@Service
public class SkillTalentService {

	
	@Autowired
	private SkillTalentRepository skillTalentRepository;
	@Autowired
	private CounterService counterService;

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

	public String updateSkillTalent(SkillTalent skillTalent) {
		JSONObject jsonObject = new JSONObject();

		skillTalentRepository.save(skillTalent);
		Counter counter =counterService.getUCounter(skillTalent.getUid());
		try {
			jsonObject.put("message", skillTalent.getName1()+" Updated successfully");
			jsonObject.put("status", "success");
			jsonObject.put("noVotes", counter.getNoVotes());
			jsonObject.put("noTVotes", counter.getTotal());
			
			String newSkills="<span class=\"label label-danger\">"+skillTalent.getName1()+"</span> <span class=\"label label-success\">"+skillTalent.getName2()+"</span> <span class=\"label label-info\">"+skillTalent.getName3()+"</span> <span class=\"label label-warning\">"+skillTalent.getName4()+"</span> <span class=\"label label-primary\">"+skillTalent.getName5()+"</span>";
			jsonObject.put("newSkill", newSkills);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	public void deleteSkillTalent(int id) {
		skillTalentRepository.deleteById(id);

	}

	public SkillTalent getUSkillTalent(int id) {
		// TODO Auto-generated method stub
		return skillTalentRepository.findByUid(id);
	}

}
