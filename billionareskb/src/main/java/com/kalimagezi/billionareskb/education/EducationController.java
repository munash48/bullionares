package com.kalimagezi.billionareskb.education;

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
import com.kalimagezi.billionareskb.user.UserModelRepository;
@Controller
public class EducationController {
	
	@Autowired
	private UserModelRepository userModelRepository;
	
	@Autowired
	private EducationService educationService;
	@Autowired
	private CounterService counterService;
	
	@RequestMapping(value="/home/updateEducation", method = RequestMethod.POST)
	public String updadeUser ( @RequestParam("eId") Integer id, 
			@RequestParam("level") String level,
			@RequestParam("award") String award,
			@RequestParam("institution") String institution,
			@RequestParam("website") String website,
			@RequestParam("completionDate") String completionDate

			) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  
		  User user = userModelRepository.findByEmail(authentication.getName());
		  Counter counter= counterService.getUCounter(user.getId());
		  Education  education = educationService.getUEducation(user.getId());
		  if(education.getLevel()==null) {
			counter.setNoVotes(counter.getNoVotes()+2);
			counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
		       		 counter.getNoReports()+counter.getNoVotes());
				counterService.addCounter(counter);
		  }
	
		education.setLevel(level);
		education.setAward(award);
		education.setInstitution(institution);
		education.setWebsite(website);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-MM-dd");

		LocalDate date2 = LocalDate.parse(completionDate, dtf);
		education.setCompletionDate(date2);
			
			
		educationService.addEducation(education);


		return "redirect:/home?educationupdate=success";
		
	}


}
