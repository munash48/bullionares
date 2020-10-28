package com.kalimagezi.billionareskb.skillTalent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@PostMapping(value="/updateSkill", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updadeUser ( @RequestBody SkillTalent skillTalent) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  
		  User user = userModelRepository.findByEmail(authentication.getName());
		  Counter counter= counterService.getUCounter(user.getId());
		  if(skillTalent==null) {
			  
			counter.setNoVotes(counter.getNoVotes()+2);
			counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
		       		 counter.getNoReports()+counter.getNoVotes());
				counterService.addCounter(counter);
		  }
		
		


		return skillTalentService.addSkillTalent(skillTalent);
		
	}
}
