package com.kalimagezi.billionareskb.skillTalent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;
import com.kalimagezi.billionareskb.user.User;
import com.kalimagezi.billionareskb.user.UserModelRepository;

@Controller
public class SkillTalentController {
	
	
	@Autowired
	private UserModelRepository userModelRepository;
	@Autowired
	private SkillTalentService skillTalentService;
	@Autowired
	private CounterService counterService;
	
	@RequestMapping(value="/home/updateSkill", method = RequestMethod.POST)
	public String updadeUser ( @RequestParam("sId") Integer id, 
			@RequestParam("name1") String name1,
			@RequestParam("name2") String name2,
			@RequestParam("name3") String name3,
			@RequestParam("name4") String name4,
			@RequestParam("name5") String name5,
			@RequestParam("description") String description
			) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  
		  User user = userModelRepository.findByEmail(authentication.getName());
		  Counter counter= counterService.getUCounter(user.getId());
		  SkillTalent  skillTalent = skillTalentService.getUSkillTalent(user.getId());
		  if(skillTalent==null) {
			  
			counter.setNoVotes(counter.getNoVotes()+2);
			counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
		       		 counter.getNoReports()+counter.getNoVotes());
				counterService.addCounter(counter);
		  }
	
		skillTalent.setName1(name1);
		skillTalent.setName2(name2);
		skillTalent.setName3(name3);
		skillTalent.setName4(name4);
		skillTalent.setName5(name5);
		skillTalent.setDescription(description);
		
		
		
		skillTalentService.addSkillTalent(skillTalent);


		return "redirect:/home?skillupdate=success";
		
	}
}
