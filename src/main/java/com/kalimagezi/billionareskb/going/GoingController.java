package com.kalimagezi.billionareskb.going;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	

	@RequestMapping(value = "/addGoing", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createOpinion(@RequestParam("eid") Integer eid, @RequestParam("uid") int uid, @RequestParam("euid") int euid

	) {
		JSONObject jsonObject = new JSONObject();
		
		List <Going> ugoings = goingService.getAllGoingsByEid(eid);

		Event event = eventService.getEvent(eid).orElseThrow(null);
		event.setGoing(event.getGoing()+1);
		Going going = new Going();

		going.setEid(eid);
		going.setUid(uid);
		

		Counter counter=counterService.getUCounter(euid);
		counter.setNoVotes(counter.getNoVotes()+1);
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());
		
		for(Going ugoing: ugoings) {
			
			if (going.getUid()==ugoing.getUid()) {
				
				try {
					jsonObject.put("message", "You already made a Going decision ");
					jsonObject.put("status", "failed");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return jsonObject.toString();
				
			}
		}

		        counterService.addCounter(counter);
		        
				goingService.addGoing(going);

				eventService.addEvent(event);
				
				try {
					jsonObject.put("message", "Your Going decision is counted.");
					jsonObject.put("status", "success");
					jsonObject.put("newGoing",  "Going ("+event.getGoing()+")");
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				return jsonObject.toString();
		
			
	}
}
