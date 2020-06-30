package com.kalimagezi.billionareskb.career;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
import com.kalimagezi.billionareskb.user.UserService;
@Controller
public class CareerController {
	
	
	@Autowired
	private CareerService careerService;
	@Autowired
	private UserService userService;
	@Autowired
	private CounterService counterService;

	
	@RequestMapping(value="/home/updateCareer", method = RequestMethod.POST)
	public String updadeUser ( @RequestParam("cId") Integer id, 
			@RequestParam("jobTitle") String jobTitle,
			@RequestParam("specialization") String specialization,
			@RequestParam("website") String website,
			@RequestParam("description") String description,
			@RequestParam("startDate") String startDate
			) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  
		  User user = userService.findByEmail(authentication.getName());
		  Counter counter= counterService.getUCounter(user.getId());
		  Career  career = careerService.getUCareer(user.getId());
		  if(career.getJobTitle()==null) {
			counter.setNoVotes(counter.getNoVotes()+2);
			counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()+
		       		 counter.getNoReports()+counter.getNoVotes());
				counterService.addCounter(counter);
		  }

			career.setJobTitle(jobTitle);
			career.setSpecialization(specialization);
			career.setWebsite(website);
			career.setDescription(description);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-MM-dd");

			LocalDate date2 = LocalDate.parse(startDate, dtf);
			career.setStartDate(date2);

			

			
	    careerService.addCareer(career);


		return "redirect:/home?careerupdate=success";
		
	}


}
