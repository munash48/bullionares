package com.kalimagezi.billionareskb.analysis;

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
import com.kalimagezi.billionareskb.user.User;
import com.kalimagezi.billionareskb.user.UserService;
import com.kalimagezi.billionareskb.analysis.Analysis;
import com.kalimagezi.billionareskb.analysis.AnalysisService;

@Controller
public class AnalysisController {
	
	@Autowired
	private AnalysisService analysisService;
	@Autowired
	private EventService eventService;
	@Autowired
	private CounterService counterService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/addAnalysis", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createAnalysis(@RequestParam("eid") Integer eid, @RequestParam("description") String description,
			@RequestParam("uid") int uid

	) {
		JSONObject jsonObject = new JSONObject();

		List<Analysis> analysiss = analysisService.getAnalysissByEid(eid);

		for (Analysis aanalysis : analysiss) {

			if (uid == aanalysis.getUid()) {
				
				try {
					jsonObject.put("message", "You already analysed this Event");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return jsonObject.toString();

			}
		}
		
		Analysis analysis = new Analysis();

		if (description != "") {
		

			

			analysis.setDescription(description);
			analysis.setEid(eid);
			analysis.setUid(uid);			
			Counter counter = counterService.getUCounter(uid);
			counter.setNoOpinions(counter.getNoOpinions()+1);

			Event event = eventService.getEvent(eid).orElseThrow(null);
			event.setNoAnalyis(event.getNoAnalyis()+1);
			Counter eCounter=counterService.getUCounter(event.getUid());
			eCounter.setNoOpinions(counter.getNoOpinions()+1);
			analysisService.addAnalysis(analysis);

			eventService.addEvent(event);
			try {
				jsonObject.put("message", "You have added a written analysis ");
				jsonObject.put("newAnaysis",  "Analysis ("+event.getNoAnalyis()+")");
				jsonObject.put("id", event.getId());
				jsonObject.put("analysis", event.getDescription());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return jsonObject.toString();
		}
		
		try {
			jsonObject.put("message", "The analysis cannot be empty");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject.toString();

	}

	

}
