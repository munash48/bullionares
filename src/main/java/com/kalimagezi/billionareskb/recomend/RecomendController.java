package com.kalimagezi.billionareskb.recomend;

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
public class RecomendController {
	@Autowired
	private RecomendService recomendService;
	@Autowired
	private JobaddService jobaddService;
	@Autowired
	private CounterService counterService;

	@RequestMapping(value = "/addRecomend", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createOpinion(@RequestParam("jaid") Integer jaid, @RequestParam("uid") int uid, @RequestParam("jauid") int jauid

	) {
		JSONObject jsonObject = new JSONObject();

		List<Recomend> recomendations = recomendService.getAllRecomendsByJaid(jaid);

		Jobadd jobadd = jobaddService.getJobadd(jaid).orElseThrow(null);
		
        jobadd.setRecomended(jobadd.getRecomended()+1);
		
        Recomend recomend = new Recomend();
		recomend.setJaid(jaid);
		recomend.setUid(uid);

		Counter counter = counterService.getUCounter(jauid);
		counter.setNoVotes(counter.getNoVotes()+1);
		counter.setTotal(counter.getNoArticles()+counter.getNoConnections()+counter.getNoInvites()+counter.getNoOpinions()-
	       		 counter.getNoReports()+counter.getNoVotes());

		for (Recomend arecomend : recomendations) {

			if (recomend.getUid() == arecomend.getUid()) {
				
				try {
					jsonObject.put("message", "You have already made recomendation");
					jsonObject.put("status", "failed");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return jsonObject.toString();

			}
		}
		

		recomendService.addRecomend(recomend);
		jobaddService.addJobadd(jobadd);
		
		counterService.addCounter(counter);

		
		
		try {
			jsonObject.put("message", "You have made a recommdation" + jobadd.getId());
			jsonObject.put("status", "success");
			jsonObject.put("newRecommend",  "Positives ("+jobadd.getRecomended()+")");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonObject.toString();

	}
}
