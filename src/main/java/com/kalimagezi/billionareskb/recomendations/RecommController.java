package com.kalimagezi.billionareskb.recomendations;


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
	
	@RequestMapping(value="/addRecommend", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createRecommendations ( @RequestParam("jaid") Integer jaid, 
			@RequestParam("description") String description,
			@RequestParam("jauid") int jauid,
			@RequestParam("uid") int uid

			) {
		JSONObject jsonObject = new JSONObject();
		
		List<Recommendations> recommends = recommendationsService.getRecommendationssByJaid(jaid);

		for (Recommendations recomm : recommends) {

			if (uid == recomm.getUid()) {
				
				try {
					jsonObject.put("message", "You already recommended this Job ADD");
					jsonObject.put("status", "failed");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return jsonObject.toString();

			}
		}
		
		
		if (!description.isEmpty()) {
		
		Recommendations  recommendations = new Recommendations();

		recommendations.setDescription(description);
		recommendations.setJaid(jaid);
		recommendations.setUid(uid);
		Counter counter2= counterService.getUCounter(jauid);
		counter2.setNoOpinions(counter2.getNoOpinions()+1);
		Counter counter= counterService.getUCounter(uid);
		counter.setNoOpinions(counter.getNoOpinions()+1);
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());
			counterService.addCounter(counter);
			counterService.addCounter(counter2);
			
		Jobadd jobadd =	jobaddService.getJobadd(jaid).orElseThrow(null);
		jobadd.setNoRecomends(jobadd.getNoRecomends()+1);		
		recommendationsService.addRecommendations(recommendations);
		try {
			jsonObject.put("message", "Recommendation  " +recommendations.getId() +" Created  successfully.");
			jsonObject.put("status", "success");
			jsonObject.put("newRecommendations",  "Written ("+jobadd.getNoRecomends()+")");
			jsonObject.put("id", jobadd.getId());
			jsonObject.put("recommendation", recommendations.getDescription());
			jsonObject.put("noTVotes", counter.getTotal());
			jsonObject.put("noOpinion", counter.getNoOpinions());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return jsonObject.toString();
		}
		try {
			jsonObject.put("message", "Recommendation cant be empty in description");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonObject.toString();
		
		
	}
}
