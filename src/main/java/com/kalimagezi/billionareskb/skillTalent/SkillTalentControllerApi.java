package com.kalimagezi.billionareskb.skillTalent;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SkillTalentControllerApi {
	
	@Autowired
	private SkillTalentService skillTalentService;
	
	@RequestMapping("/skillTalents")
	public List<SkillTalent> getAllSkillTalents(){
		return skillTalentService.getAllSkillTalents();
	}
	@RequestMapping("/skillTalent/{id}")
	public Optional<SkillTalent> getSkillTalent(@PathVariable int id){
		return skillTalentService.getSkillTalent(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/skillTalent")
	public void addSkillTalent(@RequestBody SkillTalent skillTalent ){
		skillTalentService.addSkillTalent(skillTalent);;
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/skillTalent/{id}")
	public void updateSkillTalent(@RequestBody SkillTalent skillTalent, @PathVariable int id){
		skillTalentService.updateSkillTalent(skillTalent);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/skillTalent/{id}")
	public void deleteSkillTalent(@PathVariable int id ){
		skillTalentService.deleteSkillTalent(id);
	}

}
