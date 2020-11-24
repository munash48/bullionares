package com.kalimagezi.billionareskb.recomendations;


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
import com.kalimagezi.billionareskb.jobadd.Jobadd;
import com.kalimagezi.billionareskb.jobadd.JobaddService;
@Controller
public class RecommController {

	@Autowired
	private RecommendationsService recommendationsService;
	@Autowired
	private CounterService counterService;
	@Autowired
	private JobaddService jobaddService;
	
	@RequestMapping(value="/createRecommendations", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createRecommendations ( @RequestParam("jaid") Integer jaid, 
			@RequestParam("description") String description,
			@RequestParam("uid") int uid

			) {
		JSONObject jsonObject = new JSONObject();
		
		
		if (!description.isEmpty()) {
		
		Recommendations  recommendations = new Recommendations();

		recommendations.setDescription(description);
		recommendations.setJaid(jaid);
		recommendations.setUid(uid);
		Counter counter= counterService.getUCounter(uid);
		counter.setNoOpinions(counter.getNoOpinions()+1);
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());
			counterService.addCounter(counter);
			
		Jobadd jobadd =	jobaddService.getJobadd(jaid).orElseThrow(null);
		jobadd.setNoRecomends(jobadd.getNoRecomends()+1);		
		recommendationsService.addRecommendations(recommendations);
		try {
			jsonObject.put("message", "Recommendations  " +recommendations.getId() +" Created  successfully.");
			jsonObject.put("newRecommendations",  "Analysis ("+jobadd.getNoRecomends()+")");
			jsonObject.put("id", jobadd.getId());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return jsonObject.toString();
		}
		try {
			jsonObject.put("message", "Recommendations cant be empty in description");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
		
		
	}
}
