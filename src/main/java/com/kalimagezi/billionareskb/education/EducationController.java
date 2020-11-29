package com.kalimagezi.billionareskb.education;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;

import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;
import com.kalimagezi.billionareskb.user.User;
import com.kalimagezi.billionareskb.user.UserModelRepository;
@Controller
public class EducationController {
	
	@Autowired
	private UserModelRepository userModelRepository;
	
	@Autowired
	private EducationService educationService;
	@Autowired
	private CounterService counterService;
	
	@PostMapping(value="/updateEducation", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updadeUser ( @RequestBody Education education) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  
		  User user = userModelRepository.findByEmail(authentication.getName());
		  Counter counter= counterService.getUCounter(user.getId());
		  Education education2=educationService.getEducation(education.getId()).orElseThrow(null);
		  if(education2.getAward()==null) {
			counter.setNoVotes(counter.getNoVotes()+2);
			counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
		       		 counter.getNoReports()+counter.getNoVotes());
				counterService.addCounter(counter);
		  }


		return educationService.addEducation(education);
		
	}


}
