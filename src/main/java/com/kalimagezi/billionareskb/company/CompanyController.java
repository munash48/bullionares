package com.kalimagezi.billionareskb.company;

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
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	@Autowired
	private UserService userService;
	@Autowired
	private CounterService counterService;
	
	@RequestMapping(value="/home/updateCompany", method = RequestMethod.POST)
	public String updadeUser ( @RequestParam("cId") Integer id, 
			@RequestParam("name") String name,
			@RequestParam("type") String type,
			@RequestParam("address") String address,
			@RequestParam("website") String website,
			@RequestParam("creationDate") String creationDate,
			@RequestParam("jobCapacity") Integer jobCapacity,
			@RequestParam("description") String description,
			@RequestParam("workingHours") String workingHours
			) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		  
		  User user = userService.findByEmail(authentication.getName());
		  Company  company = companyService.getUCompany(user.getId());
		  if(company.getName()==null) {
		  Counter counter= counterService.getUCounter(user.getId());
			counter.setNoVotes(counter.getNoVotes()+2);
			counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
		       		 counter.getNoReports()+counter.getNoVotes());
				counterService.addCounter(counter);
				
		  }

			
		company.setName(name);
		company.setType(type);
		company.setAddress(address);
		company.setWebsite(website);
		company.setJobCapacity(jobCapacity);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-MM-dd");

		LocalDate date2 = LocalDate.parse(creationDate, dtf);	
		company.setCreationDate(date2);
		company.setDescription(description);	
		company.setWorkingHours(workingHours);	

			
	    companyService.addCompany(company);


		return "redirect:/home?companyupdate=success";
		
	}

}
