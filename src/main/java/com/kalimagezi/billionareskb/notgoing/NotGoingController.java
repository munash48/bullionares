package com.kalimagezi.billionareskb.notgoing;

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


@Controller
public class NotGoingController {
	@Autowired
	private NotGoingService notGoingService;
	@Autowired
	private EventService eventService;
	@Autowired
	private CounterService counterService;

	@RequestMapping(value = "/addNotGoing", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createOpinion(@RequestParam("eid") Integer eid, @RequestParam("uid") int uid, @RequestParam("euid") int euid

	) {
		JSONObject jsonObject = new JSONObject();

		List<NotGoing> unotgoings = notGoingService.getAllNotGoingsByEid(eid);

		Event event = eventService.getEvent(eid).orElseThrow(null);
		event.setNotGoing(event.getNotGoing() + 1);
		NotGoing notGoing = new NotGoing();

		notGoing.setEid(eid);
		notGoing.setUid(uid);

		Counter counter = counterService.getUCounter(euid);
		counter.setNoReports(counter.getNoReports()+1);
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());

		for (NotGoing unotgoing : unotgoings) {

			if (notGoing.getUid() == unotgoing.getUid()) {
				
				try {
					jsonObject.put("message", "You already made a Not-Going decision ");
					jsonObject.put("status", "failed");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return jsonObject.toString();

			}
		}

		notGoingService.addNotGoing(notGoing);
		eventService.addEvent(event);
		counterService.addCounter(counter);
		
		try {
			jsonObject.put("message", "Your Not-Going decision is counted.");
			jsonObject.put("status", "success");
			jsonObject.put("newNotGoing",  "Not Going ("+event.getNotGoing()+")");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject.toString();

	}

}
