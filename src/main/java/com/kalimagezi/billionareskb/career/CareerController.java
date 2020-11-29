package com.kalimagezi.billionareskb.career;


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
import com.kalimagezi.billionareskb.user.UserService;
@Controller
public class CareerController {
	
	
	@Autowired
	private CareerService careerService;
	@Autowired
	private UserService userService;
	@Autowired
	private CounterService counterService;

	
	@PostMapping(value="/updateCareer", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updadeUser ( @RequestBody Career career ) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  
		  User user = userService.findByEmail(authentication.getName());
		  Counter counter= counterService.getUCounter(user.getId());
		  Career career2 =careerService.getCareer(career.getId()).orElseThrow(null);
		  
		  if(career2.getJobTitle()==null) {
			counter.setNoVotes(counter.getNoVotes()+2);
			counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()+
		       		 counter.getNoReports()+counter.getNoVotes());
				counterService.addCounter(counter);
		  }
			


		return careerService.addCareer(career);
		
	}


}
