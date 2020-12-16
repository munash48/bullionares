package com.kalimagezi.billionareskb.counter;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class CounterController {
	@Autowired
	private CounterService counterService;
	
	
	@RequestMapping(value="/admin/resetCounter", method = RequestMethod.GET)
	public String resetCounter () {
		
	List<Counter> allcounters=counterService.getAllCounters();
	
	for(Counter counter: allcounters) {
		counter.setNoArticles(1);
		counter.setNoConnections(1);
		counter.setNoInvites(1);
		counter.setNoOpinions(1);
		counter.setNoReports(1);
		counter.setNoVotes(1);
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		counter.getNoReports()+counter.getNoVotes());
			counterService.addCounter(counter);
		counterService.addCounter(counter);
	}
		
		
		
	return "redirect:/admin?resetCounter=success";
		
	}
	

}

