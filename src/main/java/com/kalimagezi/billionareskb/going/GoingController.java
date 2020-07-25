package com.kalimagezi.billionareskb.going;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;
import com.kalimagezi.billionareskb.event.Event;
import com.kalimagezi.billionareskb.event.EventService;
import com.kalimagezi.billionareskb.going.Going;
import com.kalimagezi.billionareskb.going.GoingService;

@Controller
public class GoingController {
	@Autowired
	private GoingService goingService;
	@Autowired
	private EventService eventService;
	@Autowired
	private CounterService counterService;
	

	@RequestMapping(value = "/home/addGoing", method = RequestMethod.POST)
	public String createOpinion(@RequestParam("eid") Integer eid, @RequestParam("uid") int uid

	) {
		
		List <Going> ugoings = goingService.getAllGoingsByEid(eid);

		Event event = eventService.getEvent(eid).orElseThrow(null);
		event.setGoing(event.getGoing()+1);
		Going going = new Going();

		going.setEid(eid);
		going.setUid(uid);
		
		Counter counter=counterService.getUCounter(event.getUid());
		counter.setNoVotes(counter.getNoVotes()+1);
		
		for(Going ugoing: ugoings) {
			
			if (going.getUid()==ugoing.getUid()) {
				
				return "redirect:/home?goingFailed=failed";
				
			}
		}
				
				goingService.addGoing(going);

				eventService.addEvent(event);
				

				return "redirect:/home?goingAdded=success";
		
			
	}
}
